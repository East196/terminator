package com.github.east196.xcode.bot

import com.google.common.base.CaseFormat
import java.util.List
import org.eclipse.xtend.lib.annotations.Data

class MongoBot {

    def static void main(String[] args) {
        var src = '''E:\backup\xcode\Mongo数据库设计文档.doc'''
        val basePackageName = '''cn.device.mongo'''
        val basePath = '''E:\workspace\github\east196\java\xcode\src\main\'''
        val beanBasePath = '''E:\workspace\github\east196\java\xcode\src\main\java\cn\device\mongo\'''
        val beanTestBasePath = '''E:\workspace\github\east196\java\xcode\src\test\java\cn\device\mongo\'''

        val tables = Bots.tables(src)
        println("--表格总数："+tables.size())

        var visonTables=tables.map [ table |
            var rowNum = table.numRows()
            println("表格行数："+rowNum)
            var fields = newArrayList()
            for(var j = 3; j < rowNum; j++) {
                var row = table.getRow(j);
                var name = row.getCell(0).text.trim
                var type = row.getCell(1).text.trim
                var require = row.getCell(3).text.trim
                var key = row.getCell(4).text.trim
                var comment = row.getCell(5).text.trim
                var show = row.getCell(6).text.trim
                var field = new VisonField(name, type, require, key, comment, show)
                fields.add(field)
            }
            //			fields.forEach[print(it)]

            var klassType = table.getRow(1).getCell(2).text.trim
            var klassName = table.getRow(1).getCell(3).text.trim
            var gene = table.getRow(1).getCell(4).text.trim
            var visonTable = new VisonTable(gene,klassType, klassName, fields)
            return visonTable
        ]

        visonTables.filter[it.gene=="Now"].forEach[visonTable|
            println('''start gene   «visonTable.klassType»''')
            var klassType = visonTable.klassType

            var content = showList(basePackageName, visonTable)
            var path = '''«basePath»resources\static\views\«klassType.trim.toFirstLower»\«klassType.trim.toFirstLower»List.html'''
            Bots.copy(content,path)

            content = add(basePackageName, visonTable)
            path = '''«basePath»resources\static\views\«klassType.trim.toFirstLower»\add«klassType.trim.toFirstUpper».html'''
            Bots.copy(content,path)

            content = edit(basePackageName, visonTable)
            path = '''«basePath»resources\static\views\«klassType.trim.toFirstLower»\edit«klassType.trim.toFirstUpper».html'''
            Bots.copy(content,path)

            content = jsController(basePackageName, visonTable)
            path = '''«basePath»resources\static\js\controllers\«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»Controller.js'''
            Bots.copy(content,path)

            content = dataTable(basePackageName, visonTable)
            path = '''«basePath»resources\static\js\scripts\«klassType.trim.toFirstLower»\«klassType.trim.toFirstLower»Table.js'''
            Bots.copy(content,path)



            content = bean(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper».java'''
            Bots.copy(content,path)

            content = service(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»Service.java'''
            Bots.copy(content,path)

            content = mongoServiceImpl(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»MongoServiceImpl.java'''
            Bots.copy(content,path)

            content = mongoDao(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»Mongo.java'''
            Bots.copy(content,path)

            content = mongoDaoImpl(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»MongoImpl.java'''
            Bots.copy(content,path)

            content = controller(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»Controller.java'''
            Bots.copy(content,path)

            content = validator(basePackageName, visonTable)
            path = '''«beanBasePath»«klassType.trim.toFirstLower»\«klassType.trim.toFirstUpper»Validator.java'''
            Bots.copy(content,path)

            content = httpcaller(basePackageName, visonTable)
            path = '''«beanTestBasePath»http\«klassType.trim.toFirstUpper»HttpCaller.java'''
            Bots.copy(content,path)

            content = httpcallertest(basePackageName, visonTable)
            path = '''«beanTestBasePath»http\«klassType.trim.toFirstUpper»HttpCallerTest.java'''
            Bots.copy(content,path)

            println("")
            content = appState(basePackageName, visonTable)
            println(content)

            println("")
            content = sidebarLi(basePackageName, visonTable)
            print(content)
        ]
    }


    def static appState(String string, VisonTable table) {
        var klassType = table.klassType
        var klassName = table.klassType.toFirstLower
        '''
                 // «table.klassName»
        .state('«klassName»List', {
            url: "/«klassName»List.html",
            templateUrl: "views/«klassName»/«klassName»List.html",
            data: {pageTitle: '«table.klassName»'},
            controller: "GeneralPageController",
            resolve: {
				deps : [ '$ocLazyLoad', function($ocLazyLoad) {
					return $ocLazyLoad.load([ {
						name : 'angularFileUpload',
						files : [ 'assets/global/plugins/angularjs/plugins/angular-file-upload/angular-file-upload.min.js']
					},{
						name : 'MetronicApp',
						insertBefore : '#ng_load_plugins_before', // load
						files : [ 'js/controllers/GeneralPageController.js','js/controllers/«klassName»/«klassType»Controller.js','js/scripts/«klassName»/«klassName»Table.js' ]
					} ]);
				} ]
            }
        })
'''
    }

    def static sidebarLi(String string, VisonTable table) {
        var klassName = table.klassType.toFirstLower
        '''
                <li>
                    <a href="#/«klassName»List.html">
			<i class="icon-home"></i>
			<span class="title">«table.klassName»</span>
			</a>
		</li>
'''
    }

    def static showList(String basePackageName, VisonTable table) {
        val fields = table.fields.filter[it.show.contains("L")].toList
        val searchFields = table.fields.filter[it.show.contains("S")].toList
        var klassType = table.klassType
        '''
<div ng-controller="«klassType.toFirstUpper»Controller">
<!-- BEGIN PAGE HEADER-->
<div class="form-search">
		    <form action="#" class="form-horizontal form-bordered">
		     «FOR f : searchFields»
			    «IF searchFields.indexOf(f)%3==0»
			    <div class="form-group">
			    «ENDIF»
			        <label class="col-sm-1 control-label">«f.comment.split("-").get(0)»：</label>
                    <div class="col-sm-3">
                         «parseSearchInput(table,f)»
                    </div>
				«IF searchFields.indexOf(f)%3==2»
				</div>
			     «ENDIF»
				 «IF searchFields.indexOf(f)==searchFields.length-1 && searchFields.indexOf(f)%3==0»
				     <label class="col-sm-8 control-label"><button class="btn red search-submit">查询</button></label>
			         </div>
			    «ENDIF»
			     «IF searchFields.indexOf(f)==searchFields.length-1 && searchFields.indexOf(f)%3==1»
			     <label class="col-sm-4 control-label"><button class="btn red search-submit">查询</button></label>
			         </div>
			    «ENDIF»
			     «IF searchFields.indexOf(f)==searchFields.length-1 && searchFields.indexOf(f)%3==2»
			         <div class="form-group">
				     <label class="col-sm-12 control-label"><button class="btn red search-submit">查询</button></label>
			         </div>
			    «ENDIF»
			«ENDFOR»
		</form>
	</div>
	<!-- BEGIN MAIN CONTENT -->
	<div class="row">
		<!-- BEGIN EXAMPLE TABLE PORTLET-->
		<div class="col-md-12 dev-msg">
			<div class="portlet box blue-hoki">
				<div class="portlet-title">
					<div class="caption">
						«table.klassName»信息
					</div>
					<div class="actions">
					    <div class="btn-group">
							<a class="btn default btn-search" href="#">搜索<i
								class="fa fa-angle-up"></i></a>
						</div>
						<div class="btn-group">
							<a class="btn default" href="#" data-toggle="dropdown"> 字段<i
								class="fa fa-angle-down"></i>
							</a>
							<div id="«klassType.toFirstLower»_sample_4_column_toggler"
								class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
								<label><input type="checkbox" checked data-column="0">序号</label>
								 «FOR f : fields»
								 <label><input type="checkbox" checked data-column="«fields.indexOf(f)+1»"
									value="«f.name.toFirstLower»">«f.comment.split("-").get(0)»</label>
								 «ENDFOR»
							</div>
						</div>
					</div>
				</div>
				<div class="portlet-body" ng-controller="«klassType»-BtnGroupController">
					<div class="hs-btn-group">
						<button class="btn btn-primary btn-sm" ng-click="add('lg')">
							<i class="glyphicon glyphicon-plus"></i>增加
						</button>
						<button id="«klassType.toFirstLower»-editBtn" class="btn btn-success btn-sm"
							ng-click="edit('lg')">
							<i class="glyphicon glyphicon-pencil"></i>修改
						</button>
						<button id="«klassType.toFirstLower»-deleteBtn" class="btn btn-danger btn-sm"
							ng-click="remove()">
							<i class="glyphicon glyphicon-trash"></i>删除
						</button>
					</div>
					<table class="table table-striped table-bordered table-hover"
						id="«klassType.toFirstLower»-table" width="100%">
						<thead>
							<tr>
								<th><input type="checkbox" name="selectAll"
									class="group-checkable" data-set="#«klassType.toFirstLower»-table .checkboxes">
								</th>
								 «FOR f : fields»
								  <th class="hidden-xs">«f.comment.split("-").get(0)»</th>
								 «ENDFOR»
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
		<!-- END EXAMPLE TABLE PORTLET-->
	</div>
	<!-- END MAIN CONTENT -->
</div>
<!-- BEGIN MAIN JS -->
<script>
	«klassType»TableAdvanced.init();
	ComponentsPickers.init(); // init todo page
	ComponentsFormTools.init(); // init todo page
</script>
<!-- END MAIN JS -->
		'''
    }

    def static add(String basePackageName, VisonTable table) {
        val fields = table.fields.filter[it.show.contains("C")].toList
        '''
<div class="modal-header">
     <h3 class="modal-title">新增«table.klassName»信息</h3>
</div>
	 <div class="modal-body">
			<div class="portlet-body form">
				<!-- BEGIN FORM-->
				<form action="#" id="«table.klassType.toFirstLower»-add-form" class="form-horizontal">
					<div class="form-body">
				 «FOR f : fields»
			          «IF fields.indexOf(f)%2==0»
			          <div class="form-group">
			          «ENDIF»
                           <div class="hs-td col-md-6">
                                <label class="control-label col-md-4">«f.comment.split("-").get(0)»
								«IF f.require.contains("A")»
								<span class="required"> * </span>
								«ENDIF»
								</label>
                                <div class="col-md-8">
                                	<div class="input-icon right">
                               		<i class="fa"></i> «parseInput(table,f)»
                                	</div>
                                </div>
							</div>
				     «IF fields.indexOf(f)%2==1|| fields.indexOf(f) == fields.length-1»
				     </div>
			         «ENDIF»
			     «ENDFOR»
			        <div class="form-group">
					    <div id="message" class="alert alert-danger display-hide">
						    <button class="close" data-close="alert"></button>
					    </div>
				    </div>
					<div class="form-actions">
						<div class="row">
							<div class="modal-footer">
								<!-- ng-click="ok() -->
								<button type="submit" class="btn btn-primary">新增</button>
								<button type="button" class="btn btn-danger" ng-click="cancel()">取消</button>
							</div>
						</div>
					</div>
				</form>
				<!-- END FORM-->
			</div>
			</div>
			<div class="modal-footer"></div>
			<!-- BEGIN MAIN JS -->
			<script>
			ComponentsPickers.init();
			</script>
			<!-- END MAIN JS -->

		'''
    }

    def static edit(String basePackageName, VisonTable table) {
        val hideFields = table.fields.filter[it.show.contains("H")].toList
        val fields = table.fields.filter[it.show.contains("U")].toList
        var klassType = table.klassType
        '''
<div class="modal-header">
     <h3 class="modal-title">编辑«table.klassName»信息</h3>
</div>
		<div class="modal-body">
			<div class="portlet-body form">
				<!-- BEGIN FORM-->
				<form action="#" id="«klassType.toFirstLower»-edit-form" class="form-horizontal">
					<div class="form-body">
				 «FOR f : hideFields»
				 <input type="hidden" class="form-control" ng-model="«klassType.toFirstLower».«f.name.toFirstLower»" name="«f.name.toFirstLower»" />
				 «ENDFOR»
				 «FOR f : fields»
			          «IF fields.indexOf(f)%2==0»
			          <div class="form-group">
			          «ENDIF»
			             <div class="hs-td col-md-6">
								<label class="control-label col-md-4">«f.comment.split("-").get(0)»
								«IF f.require.contains("A")»
								<span class="required"> * </span>
								«ENDIF»
								</label>
								<div class="col-md-8">
									<div class="input-icon right">
										<i class="fa"></i> «parseInput(table,f)»
									</div>
								</div>
							</div>
				     «IF fields.indexOf(f)%2==1|| fields.indexOf(f) == fields.length-1»
			           </div>
			         «ENDIF»
			     «ENDFOR»
			        <div class="form-group">
					    <div id="message" class="alert alert-danger display-hide">
						    <button class="close" data-close="alert"></button>
					    </div>
				    </div>
					<div class="form-actions">
						<div class="row">
							<div class="modal-footer">
								<!-- ng-click="ok() -->
								<button type="submit" class="btn btn-primary">修改</button>
								<button type="button" class="btn btn-danger" ng-click="cancel()">取消</button>
							</div>
						</div>
					</div>
				</form>
				<!-- END FORM-->
			</div>
			</div>
			<div class="modal-footer"></div>
			<!-- BEGIN MAIN JS -->
			<script>
			ComponentsPickers.init();
			</script>
			<!-- END MAIN JS -->

		'''
    }

    def static jsController(String basePackageName, VisonTable table) {
        val key = table.fields.findFirst[it.key.contains("P")].name.toFirstLower
        var klassType = table.klassType
        '''
'use strict';

MetronicApp.controller('«klassType.toFirstUpper»Controller', function($rootScope, $scope, $http, $timeout) {
«FOR f : table.fields.filter[it.comment.contains("-select")].toList»
«IF f.comment.split("-").length>2»
	$http.get('/controller/v1/«f.comment.split("-").get(2).toFirstLower»/', "").success(function(data, status, headers, config) {
		if (data.errcode == '0') {
			$scope.«f.comment.split("-").get(2).toFirstLower»s = data.data;
		} else {
			notific("错误", data.errmsg, 5000);
		}
	}).error(function(data, status, headers, config) {
		notific("错误", "请求失败！", 5000);
	});
	«ENDIF»
«ENDFOR»

$scope.$watch('lastModifyTime', function(newValue, oldValue) {
		$scope.lastModifyTime_LTE = moment($scope.lastModifyTime).add(1, 'days').format("YYYY-MM-DD")
	});
«FOR f : table.fields.filter[it.comment.contains("-date")].toList»
	$scope.$watch('«f.comment.split("-").get(0).toFirstLower»', function(newValue, oldValue) {
		$scope.«f.comment.split("-").get(0).toFirstLower»_LTE = moment($scope.«f.comment.split("-").get(0).toFirstLower»).add(1, 'days').format("YYYY-MM-DD")
	});
«ENDFOR»

$scope.getCitys = function() {
		if (null != $scope.provice && "undefined" != $scope.provice) {
			var citys = _.find($scope.proviceCitys, function(d) {
				return d.text == $scope.provice;
			}).children;
			$scope.citys = _.map(citys, function(d) {
				return d.text;
			});
		}
	};

});

MetronicApp.controller('«klassType»-BtnGroupController', function($rootScope, $scope, $http, $modal, $log) {
	// 新增
	$scope.add = function(size) {
		var modalInstance = $modal.open({
			templateUrl : 'views/«klassType.toFirstLower»/add«klassType.toFirstUpper».html',
			controller : 'Add«klassType.toFirstUpper»Controller',
			size : size,
			backdrop : 'static',
			resolve : {
				items : function() {
					return $scope.items;
				}
			}
		});
	};
	// 编辑
	$scope.edit = function(size) {
		// 获取选中值
		var temp = $("tbody tr input:checkbox:checked").map(function() {
			return $(this).val();
		}).toArray();

		if (temp.length == 0) {
			prompt("警告", "请选择！");
		} else {
			var id = temp[0];
			var modalInstance = $modal.open({
				templateUrl : 'views/«klassType.toFirstLower»/edit«klassType.toFirstUpper».html',
				controller : 'Edit«klassType.toFirstUpper»Controller',
				size : size,
				backdrop : 'static',
				resolve : {
					items : function() {
						return id;
					}
				}
			});
		}
	};

	// 删除
	$scope.remove = function() {
		// 获取选中值
		var temp = $("tbody tr input:checkbox:checked").map(function() {
			return $(this).val();
		}).toArray();
		if (temp.length == 0) {
			prompt("警告", "请选择！");
		} else {
			confirm("提示", "确认删除?", function() {
				$http.post('/controller/v1/«klassType.toFirstLower»/deletes', temp, '').success(function(data, status, headers, config) {
					notific("提示", "删除成功！", 5000);
					«klassType»TableAdvanced.reload();
				}).error(function(data, status, headers, config) {
					notific("错误", "删除失败！", 5000);
				});
			});
		}
	};
});

// 新增
MetronicApp.controller('Add«klassType.toFirstUpper»Controller', function($scope, $modalInstance, $http, items) {
	$scope.obj = items;
	$scope.$watch('$viewContentLoaded', function() {
		handleWysihtml5();
		handleValidation();
	});
«FOR f : table.fields.filter[it.comment.contains("-select")].toList»
«IF f.comment.split("-").length>2»
$http.get('/controller/v1/«f.comment.split("-").get(2).toFirstLower»/', "").success(function(data, status, headers, config) {
		if (data.errcode == '0') {
			$scope.«f.comment.split("-").get(2).toFirstLower»s = data.data;
		} else {
			notific("错误", data.errmsg, 5000);
		}
	}).error(function(data, status, headers, config) {
		notific("错误", "请求失败！", 5000);
	});
	«ENDIF»
«ENDFOR»
	$scope.ok = function() {
		$modalInstance.close($scope.obj);
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};

	var handleWysihtml5 = function() {
		if (!jQuery().wysihtml5) {
			return;
		}

		if ($('.wysihtml5').size() > 0) {
			$('.wysihtml5').wysihtml5({
				"stylesheets" : [ "../../assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css" ]
			});
		}
	}

	// validation using icons
	var handleValidation = function() {

		var form2 = $('#«klassType.toFirstLower»-add-form');

		form2.validate({
			errorElement : 'span',
			errorClass : 'help-block help-block-error',
			focusInvalid : false,
			ignore : "",
			rules : {
				«FOR f : table.fields.filter[it.require.toUpperCase.contains("A")].toList»
				«f.name» : {
					required : true
				},
			    «ENDFOR»
			},
			messages : {
				«FOR f : table.fields.filter[it.require.toUpperCase.contains("A")].toList»
				«f.name» : {
					required : "请输入«f.comment.split("-").get(0)»"
				},
				«ENDFOR»
			},

			invalidHandler : function(event, validator) {
				//Metronic.scrollTo(error2, -200);
			},

			errorPlacement : function(error, element) {
				var icon = $(element).parent('.input-icon').children('i');
				icon.removeClass('fa-check').addClass("fa-warning");
				icon.attr("data-original-title", error.text()).tooltip({
					'container' : '.modal-body'
				});
			},

			highlight : function(element) {
				$(element).closest('.hs-td').removeClass("has-success").addClass('has-error');
			},

			unhighlight : function(element) {

			},

			success : function(label, element) {
				var icon = $(element).parent('.input-icon').children('i');
				$(element).closest('.hs-td').removeClass('has-error').addClass('has-success');
				icon.removeClass("fa-warning").addClass("fa-check");
			},

			submitHandler : function(form) {
«FOR f : table.fields.filter[it.comment.contains("-select")].toList»
«IF f.comment.split("-").length>2»
                $scope.«klassType.toFirstLower».«f.comment.split("-").get(2).toFirstLower» = $scope.«f.comment.split("-").get(2).toFirstLower».id;
«ENDIF»
«ENDFOR»
                $("#message").hide();
				$http.post('/controller/v1/«klassType.toFirstLower»/', $scope.«klassType.toFirstLower», '').success(function(data, status, headers, config) {
					if ("0" == data.errcode) {
						$modalInstance.close($scope.obj);
					    notific("提示", "新增成功！", 5000);
					    «klassType»TableAdvanced.reload();
					} else {
						$("#message").show();
						$("#message").text(data.errmsg);
					}
				}).error(function(data, status, headers, config) {
					notific("提示", "新增失败！", 5000);
				});
			}
		});
	}
});

// 编辑
MetronicApp.controller('Edit«klassType.toFirstUpper»Controller', function($scope, $modalInstance, $http, items) {
	var id = items;
«FOR f : table.fields.filter[it.comment.contains("-select")].toList»
«IF f.comment.split("-").length>2»
$scope.«f.comment.split("-").get(2).toFirstLower»s = [];
	$http.get('/controller/v1/«f.comment.split("-").get(2).toFirstLower»/', "").success(function(data, status, headers, config) {
		if (data.errcode == '0') {
			$scope.«f.comment.split("-").get(2).toFirstLower»s = data.data;
		} else {
			notific("错误", data.errmsg, 5000);
		}
	}).error(function(data, status, headers, config) {
		notific("错误", "请求失败！", 5000);
	});
	«ENDIF»
«ENDFOR»
	$http.get('/controller/v1/«klassType.toFirstLower»/?«key»_EQ=' + id, "").success(function(data, status, headers, config) {
		if (data.errcode == '0') {
			$scope.«klassType.toFirstLower» = data.data[0];
«FOR f : table.fields.filter[it.comment.contains("-select")].toList»
«IF f.comment.split("-").length>2»
	$scope.«f.comment.split("-").get(2).toFirstLower» = _.find($scope.«f.comment.split("-").get(2).toFirstLower»s, function(n) {
				return n.id == $scope.«klassType.toFirstLower».«f.comment.split("-").get(2).toFirstLower»;
			});
	«ENDIF»
«ENDFOR»
		} else {
			notific("错误", data.errmsg, 5000);
		}
	}).error(function(data, status, headers, config) {
		notific("错误", "请求失败！", 5000);
	});
	$scope.$watch('$viewContentLoaded', function() {
		handleWysihtml5();
		handleValidation();
	});

	$scope.ok = function() {
		$modalInstance.close($scope.obj);
	};

	$scope.cancel = function() {
		$modalInstance.dismiss('cancel');
	};

	var handleWysihtml5 = function() {
		if (!jQuery().wysihtml5) {
			return;
		}

		if ($('.wysihtml5').size() > 0) {
			$('.wysihtml5').wysihtml5({
				"stylesheets" : [ "../../assets/global/plugins/bootstrap-wysihtml5/wysiwyg-color.css" ]
			});
		}
	}

	var handleValidation = function() {

		var form2 = $('#«klassType.toFirstLower»-edit-form');

		form2.validate({
			errorElement : 'span',
			errorClass : 'help-block help-block-error',
			focusInvalid : false,
			ignore : "",
			rules : {
				«FOR f : table.fields.filter[it.require.toUpperCase.contains("A")].toList»
				«f.name» : {
					required : true
				},
			    «ENDFOR»
			},
			messages : {
				«FOR f : table.fields.filter[it.require.toUpperCase.contains("A")].toList»
				«f.name» : {
					required : "请输入«f.comment.split("-").get(0)»"
				},
				«ENDFOR»
			},

			invalidHandler : function(event, validator) {
				//Metronic.scrollTo(error2, -200);
			},

			errorPlacement : function(error, element) {
				var icon = $(element).parent('.input-icon').children('i');
				icon.removeClass('fa-check').addClass("fa-warning");
				icon.attr("data-original-title", error.text()).tooltip({
					'container' : '.modal-body'
				});
			},

			highlight : function(element) {
				$(element).closest('.hs-td').removeClass("has-success").addClass('has-error');
			},

			unhighlight : function(element) {

			},

			success : function(label, element) {
				var icon = $(element).parent('.input-icon').children('i');
				$(element).closest('.hs-td').removeClass('has-error').addClass('has-success');
				icon.removeClass("fa-warning").addClass("fa-check");
			},

			submitHandler : function(form) {
«FOR f : table.fields.filter[it.comment.contains("-select")].toList»
«IF f.comment.split("-").length>2»
 				$scope.«klassType.toFirstLower».«f.comment.split("-").get(2).toFirstLower» = $scope.«f.comment.split("-").get(2).toFirstLower».id;
«ENDIF»
«ENDFOR»
                $("#message").hide();
				$http.post('/controller/v1/«klassType.toFirstLower»/', $scope.«klassType.toFirstLower», '').success(function(data, status, headers, config) {
					if ("0" == data.errcode) {
						$modalInstance.close($scope.obj);
					    notific("提示", "修改成功！", 5000);
					    «klassType»TableAdvanced.reload();
					} else {
						$("#message").show();
						$("#message").text(data.errmsg);
					}
				}).error(function(data, status, headers, config) {
					notific("提示", "修改失败！", 5000);
				});
			}
		});
	}
});
		'''
    }

    def static dataTable(String basePackageName, VisonTable table) {
        val key = table.fields.findFirst[it.key.contains("P")].name.toFirstLower
        val fields = table.fields.filter[it.show.contains("L")].toList
        var klassType = table.klassType
        '''
var «klassType»TableAdvanced = function() {
	var oTable;
	var initTable = function() {
		var table = $('#«klassType.toFirstLower»-table');

		oTable = table.DataTable({
			"scrollX" : true,
			"ajax" : {
				"url" : "/controller/v1/«klassType.toFirstLower»/page",
				"type" : "POST"
			},
			"columnDefs" : [
					{
						"searchable" : false,
						"orderable" : false,
						"targets" : 0
					},«FOR f : fields»
					«IF f.javaType.toUpperCase.equals("DATE")»{
						"render" : function(data, type, row) {
							return moment(data).format("YYYY-MM-DD HH:mm:ss");
						},
						"targets" : «fields.indexOf(f)+1»
					}«IF fields.indexOf(f) != fields.length - 1»,«ENDIF»«ENDIF»
				     «ENDFOR»
		    ],
			"columns" : [
					{
						"data" : function(data) {
							return '<label class="checkbox"><div class="checker "><span class=""><input type="checkbox" class="checkboxes" value="' + data.«key»
									+ '"/></span></div><span class="index-number"></span></label>';
						}
					},«FOR f : fields»
					{
					    "data" : "«f.name.toFirstLower»",
					    "defaultContent" : ""
					}«IF fields.indexOf(f) != fields.length - 1»,«ENDIF»
				     «ENDFOR»
			]
		});
		// 序号
		oTable.on('order.dt search.dt processing.dt', function() {
			oTable.column(0, {
				search : 'applied',
				order : 'applied'
			}).nodes().each(function(cell, i) {
				$(cell).find(".index-number").html(i + 1);
			});
		}).draw();

		var tableWrapper = $('#«klassType.toFirstLower»_sample_4_wrapper');
		var tableColumnToggler = $('#«klassType.toFirstLower»_sample_4_column_toggler');

		tableWrapper.find('.dataTables_length select').select2();

		$('input[type="checkbox"]', tableColumnToggler).change(function() {

			var column = oTable.column($(this).attr('data-column'));

			column.visible(!column.visible());
		});

		// 初始化操作，选中未选中字段，使其在表单行影藏
		$(".dropdown-checkboxes input:checkbox").not("input:checked").each(function() {
			var column = oTable.column($(this).attr('data-column'));
			column.visible(false);
		});

		// 全选
		$('input[name=selectAll]').change(function() {
			var set = jQuery(this).attr("data-set");
			var checked = jQuery(this).is(":checked");
			jQuery(set).each(function() {
				if (checked) {
					$(this).closest('span').addClass("checked");
				} else {
					$(this).closest('span').removeClass("checked");
				}
				$(this).attr("checked", checked);
				$("#«klassType.toFirstLower»-deleteBtn").attr("disabled", !checked);
			});
			jQuery.uniform.update(set);
		});

		table.on('change', 'tbody tr .checkboxes', function() {
			$(this).attr("checked", this.checked);// 赋值选中
			if (this.checked) {
				$(this).closest('span').addClass("checked");
			} else {
				$(this).closest('span').removeClass("checked");
			}
			var checkAll = table.find('.group-checkable');
			// 改变全选
			var flag = true;
			$("tbody tr .checkboxes").each(function() {
				if (!this.checked) {
					flag = false;
				}
			});

			if (flag) {
				checkAll.closest('span').addClass("checked");
			} else {
				checkAll.closest('span').removeClass("checked");
			}
			checkAll.attr("checked", flag);

			// 当选择2个以上屏蔽编辑按钮
			if ($("tbody tr .checkboxes:checked").length == 1) {
				$("#«klassType.toFirstLower»-editBtn").attr("disabled", false);
			} else {
				$("#«klassType.toFirstLower»-editBtn").attr("disabled", true);
			}

			if ($("tbody tr .checkboxes:checked").length > 0) {
				$("#«klassType.toFirstLower»-deleteBtn").attr("disabled", false);
			} else {
				$("#«klassType.toFirstLower»-deleteBtn").attr("disabled", true);
			}
		});

		$(".form-search").on('click', '.search-submit', function(e) {
			e.preventDefault();
			oTable.ajax.url("/controller/v1/«klassType.toFirstLower»/page" + getSearchParams());
			oTable.ajax.reload();
		});

		//监听查询按钮
		$(".dev-msg").on('click', '.btn-search', function(e) {
			if($(".form-search").is(":hidden")){
				$(".form-search").show();
				$(this).html('搜索<i class="fa fa-angle-down"></i>');
			}else{
				$(".form-search").hide();
				$(this).html('搜索<i class="fa fa-angle-up"></i>');
			}
		});
	}

	// 按钮组
	var hsBtnGroup = function() {
		var btns = $(".hs-btn-group");
		$(".hs-btns").html(btns.html());
		btns.remove();
		$("#«klassType.toFirstLower»-editBtn").attr("disabled", true);
		$("#«klassType.toFirstLower»-deleteBtn").attr("disabled", true);
	}

	return {
		init : function() {
			if (!jQuery().dataTable) {
				return;
			}
			initTable();
			hsBtnGroup();
		},
		reload : function() {
			oTable.ajax.reload();
			$('input[name=selectAll]').closest('span').removeClass("checked");
		}
	};
}();
		'''
    }

    def static bean(String basePackageName,VisonTable table){
        val fields = table.fields
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import org.apache.commons.lang3.builder.EqualsBuilder;
		import org.apache.commons.lang3.builder.HashCodeBuilder;
		import org.apache.commons.lang3.builder.ToStringBuilder;
		import org.apache.commons.lang3.builder.ToStringStyle;
		import org.springframework.data.annotation.Id;

	    «IF fields.exists[f|f.type.toFirstUpper.startsWith("List")]»
		import java.util.List;
		«ENDIF»
		«IF fields.exists[f|f.javaType.toUpperCase.equals("DATE")]»
		import java.util.Date;
		«ENDIF»

		public class «klassType» {

			«FOR f : fields»
			/**«f.comment.split("-").get(0)»**/
			«parseFieldAnnotation(f)»
			«ENDFOR»

			public «klassType»(){
				«FOR f : fields»
				«IF f.javaType.toUpperCase.equals("DATE")&&f.name.toFirstLower.equals("updateTime")»
				this.«f.name.toFirstLower»=new Date();
				«ENDIF»
				«ENDFOR»
			}

			public «klassType»(«fields.map[it.javaType+" "+it.name.toFirstLower].join(",")»){
				«FOR f : fields»
				this.«f.name.toFirstLower»=«f.name.toFirstLower»;
				«ENDFOR»
			}

			«FOR f : fields»
			public «f.javaType» get«f.name.toFirstUpper»() {
				return «f.name.toFirstLower»;
			}

			public void set«f.name.toFirstUpper»(«f.javaType» «f.name.toFirstLower») {
				this.«f.name.toFirstLower» = «f.name.toFirstLower»;
			}
			«ENDFOR»
			@Override
			public int hashCode() {
				return HashCodeBuilder.reflectionHashCode(this);
			}

			@Override
			public boolean equals(Object other) {
				return EqualsBuilder.reflectionEquals(this, other);
			}

			@Override
			public String toString() {
				return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
			}

		}
		'''
    }

    def static service(String basePackageName,VisonTable table){
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import java.util.List;

		import org.springframework.data.domain.Page;
		import org.springframework.data.domain.PageRequest;

		import com.github.east196.xcode.common.SearchFilter;

		public interface «klassType»Service {

			public List<«klassType»> findAll(List<SearchFilter> searchFilters);

			public Page<«klassType»> findAll(List<SearchFilter> searchFilters, PageRequest pageRequest);

			public void save(«klassType» «klassType.toFirstLower»);

			public void delete(String id);

		}
		'''
    }

    def static mongoServiceImpl(String basePackageName,VisonTable table){
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import java.util.List;

		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.data.domain.Page;
		import org.springframework.data.domain.PageRequest;
		import org.springframework.stereotype.Service;

		import com.github.east196.xcode.common.SearchFilter;

		@Service
		public class «klassType»MongoServiceImpl implements «klassType»Service{

			@Autowired
			private «klassType»Mongo «klassType.toFirstLower»Mongo;

			@Override
		    public List<«klassType»> findAll(List<SearchFilter> searchFilters) {
		         return «klassType.toFirstLower»Mongo.findAll(searchFilters,«klassType».class);
		    }

		    @Override
		    public Page<«klassType»> findAll(List<SearchFilter> searchFilters, PageRequest pageRequest) {
		         return «klassType.toFirstLower»Mongo.findAll(searchFilters, pageRequest,«klassType».class);
		    }

		    @Override
		    public void save(«klassType» «klassType.toFirstLower») {
		         «klassType.toFirstLower»Mongo.save(«klassType.toFirstLower»);
		    }

		    @Override
		    public void delete(String id) {
		         «klassType.toFirstLower»Mongo.deleteById(id);
		    }

		}
		'''
    }

    def static mongoDao(String basePackageName,VisonTable table){
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import org.springframework.data.mongodb.repository.MongoRepository;
		import com.github.east196.xcode.common.MongoSpecificationExecutor;

		public interface «klassType»Mongo extends MongoRepository<«klassType», String>, MongoSpecificationExecutor {
			// add more ...
		}
		'''
    }
    def static mongoDaoImpl(String basePackageName,VisonTable table){
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import com.github.east196.xcode.common.MongoSpecificationExecutorImpl;

		public class «klassType»MongoImpl extends MongoSpecificationExecutorImpl {
		     // add more ...
		}
		'''
    }

    def static controller(String basePackageName,VisonTable table){
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import java.util.List;
		import java.util.Map;

		import javax.validation.Valid;

		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.data.domain.Page;
		import org.springframework.data.domain.PageRequest;
		import org.springframework.validation.BindingResult;
		import org.springframework.validation.DataBinder;
		import org.springframework.validation.ObjectError;
		import org.springframework.web.bind.annotation.InitBinder;
		import org.springframework.web.bind.annotation.PathVariable;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RequestMapping;
		import org.springframework.web.bind.annotation.RequestMethod;
		import org.springframework.web.bind.annotation.RequestParam;
		import org.springframework.web.bind.annotation.RestController;

		import com.github.east196.xcode.common.DataTableResult;
		import com.github.east196.xcode.common.DataResponse;
		import com.github.east196.xcode.common.Response;
		import com.github.east196.xcode.common.SearchFilter;

		@RestController
		@RequestMapping("/controller/v1/«klassType.toFirstLower»")
		public class «klassType»Controller {

		private static final Logger LOGGER = LoggerFactory.getLogger(«klassType»Controller.class);

			@Autowired
			private «klassType»Service «klassType.toFirstLower»Service;

			@RequestMapping(value = "/page", method = RequestMethod.POST)
			public DataTableResult<List<«klassType»>> read(@RequestParam(value = "draw", required = false, defaultValue = "1") Integer draw,
			@RequestParam(value = "start", required = false, defaultValue = "0") Integer start,
			@RequestParam(value = "length", required = false, defaultValue = "20") Integer length,
			@RequestParam Map<String,String> queryMap) {
				List<SearchFilter> searchFilters = SearchFilter.fromQueryMap(queryMap, «klassType».class);
				PageRequest pageRequest = SearchFilter.sortQueryMap(queryMap, start, length);
				Page<«klassType»> «klassType.toFirstLower»s = «klassType.toFirstLower»Service.findAll(searchFilters, pageRequest);
				DataTableResult<List<«klassType»>> dataTableResult = new DataTableResult<>();
				dataTableResult.setDraw(draw);
				dataTableResult.setRecordsTotal(«klassType.toFirstLower»s.getTotalElements());
				dataTableResult.setRecordsFiltered(«klassType.toFirstLower»s.getTotalElements());
				dataTableResult.setData(«klassType.toFirstLower»s.getContent());
				return dataTableResult;
			}

			@RequestMapping(value = "/", method = RequestMethod.GET)
			public DataResponse<List<«klassType»>> read(@RequestParam Map<String,String> queryMap) {
				List<SearchFilter> searchFilters = SearchFilter.fromQueryMap(queryMap, «klassType».class);
				List<«klassType»> «klassType.toFirstLower»s = «klassType.toFirstLower»Service.findAll(searchFilters);
				return new DataResponse<List<«klassType»>>("0", "查询成功!", «klassType.toFirstLower»s);
			}

			@RequestMapping(value = "/", method = RequestMethod.POST)
			public Response createOrUpdate(@RequestBody @Valid «klassType» «klassType.toFirstLower», BindingResult result) {
				LOGGER.debug("add «klassType.toFirstLower»:  {}", «klassType.toFirstLower»);
				if (result.hasErrors()) {
					StringBuffer sb = new StringBuffer();
					for (ObjectError msg : result.getAllErrors())
						sb.append(msg.getDefaultMessage()).append(" ");
					return new Response("-1", sb.toString());
				} else {
					«klassType.toFirstLower»Service.save(«klassType.toFirstLower»);
				    return new Response("0", "ok");
				}
			}

			@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
			public Response delete(@PathVariable String id) {
				LOGGER.debug("id:  {}", id);
				«klassType.toFirstLower»Service.delete(id);
				return new Response("0", "ok");
			}

			@RequestMapping(value = "/deletes", method = RequestMethod.POST)
			public Response delete(@RequestBody List<String> ids) {
				LOGGER.debug("ids:  {}", ids);
				for (String id : ids) {
					«klassType.toFirstLower»Service.delete(id);
				}
				return new Response("0", "ok");
			}

			@InitBinder("«klassType.toFirstLower»")
			public void initBinder(DataBinder binder) {
				binder.setValidator(new «klassType»Validator());
			}
		}
		'''
    }




    def static validator(String basePackageName,VisonTable table){
        var fields=table.fields
        var klassType=table.klassType
        '''
        package «basePackageName».«klassType.trim.toFirstLower»;

		import org.springframework.validation.Errors;
		import org.springframework.validation.ValidationUtils;
		import org.springframework.validation.Validator;

		public class «klassType»Validator implements Validator {

			@Override
			public boolean supports(Class<?> arg0) {
				return «klassType».class.equals(arg0);
			}

			@Override
			public void validate(Object arg0, Errors arg1) {
				«FOR f : fields.filter[it.require.toUpperCase.contains("A")].toList»
				ValidationUtils.rejectIfEmpty(arg1, "«f.name.toFirstLower»", null, "«f.comment»不能为空！");
				«ENDFOR»
			}

		}
	    '''
    }

    def static httpcaller(String basePackageName,VisonTable table){
        var klassType=table.klassType.trim
        '''
        package «basePackageName».http;

		import java.util.List;
		import java.util.Map;

		import «basePackageName».«klassType.toFirstLower».«klassType»;
		import com.github.east196.xcode.common.DataResponse;
		import com.github.east196.xcode.common.DataTableResult;
		import com.github.east196.xcode.common.Response;
		import retrofit.http.Body;
		import retrofit.http.DELETE;
		import retrofit.http.GET;
		import retrofit.http.POST;
		import retrofit.http.Path;
		import retrofit.http.Query;
		import retrofit.http.QueryMap;

		public interface «klassType»HttpCaller {

			@POST("/controller/v1/«klassType.toFirstLower»/page")
			DataTableResult<List<«klassType»>> read(@Query("draw") Integer draw, @Query("start") Integer start, @Query("length") Integer length,
					@QueryMap Map<String, String> queryMap);

			@GET("/controller/v1/«klassType.toFirstLower»/")
			DataResponse<List<«klassType»>> read(@QueryMap Map<String, String> queryMap);

			@POST("/controller/v1/«klassType.toFirstLower»/")
			Response createOrUpdate(@Body «klassType» «klassType.toFirstLower»);

			@DELETE("/controller/v1/«klassType.toFirstLower»/{id}")
			Response delete(@Path("id") String id);

			@DELETE("/controller/v1/«klassType.toFirstLower»/")
			Response deletes(@Body List<String> ids);

		}
		'''
    }
    def static httpcallertest(String basePackageName,VisonTable table){
        var klassType=table.klassType.trim
        var klassName=table.klassType.trim.toFirstLower
        '''
        package «basePackageName».http;

		import java.util.HashMap;
		import java.util.List;
	   «IF table.fields.exists[f|f.type.toFirstUpper.startsWith("List")]»
		import java.util.ArrayList;
		«ENDIF»
		«IF table.fields.exists[f|f.type.toUpperCase.contains("DATE")]»
		import java.util.Date;
		«ENDIF»

		import org.junit.BeforeClass;
		import org.junit.Test;

		import «basePackageName».«klassName».«klassType»;
		import com.github.east196.xcode.common.DataResponse;
		import retrofit.RestAdapter;
		import retrofit.RestAdapter.LogLevel;

		public class «klassType»HttpCallerTest {

			public static «klassType»HttpCaller «klassName»HttpCaller;

			@BeforeClass
			public static void beforeClass() {
				RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(LogLevel.FULL)
						.setEndpoint("http://192.168.7.200:8099/").build();
				«klassName»HttpCaller = restAdapter.create(«klassType»HttpCaller.class);
			}

			@Test
			public void testCrud() {
				«klassType» «klassName» = new «klassType»();
				«FOR f : table.fields.toList»
				«klassName».set«f.name.toFirstUpper»(«f.defaultValue»);
				«ENDFOR»

				«klassName»HttpCaller.createOrUpdate(«klassName»);// Create
				@SuppressWarnings("unused")
				DataResponse<List<«klassType»>> read = «klassName»HttpCaller.read(new HashMap<>());// Read after Create

				«FOR f : table.fields.filter[!it.key.contains("P")].toList»
				«klassName».set«f.name.toFirstUpper»(«f.defaultValue»);
				«ENDFOR»
				«klassName»HttpCaller.createOrUpdate(«klassName»);// Update
				read = «klassName»HttpCaller.read(new HashMap<>());// Read after Update

				«klassName»HttpCaller.delete(«table.fields.findFirst[it.key.contains("P")].defaultValue»);// Delete
				read = «klassName»HttpCaller.read(new HashMap<>());// Read after Delete
			}

		}
		'''
    }

    def static parseSearchInput(VisonTable t, VisonField f) {
        return switch f.comment {
            case f.comment.contains("-date"):
                '''
                <div class="input-group input-large date-picker input-daterange" data-date-format="yyyy-mm-dd">
                     <input type="text" class="form-control" name="«f.name.toFirstLower»_GTE">
				 <span class="input-group-addon">至</span>
				 <input type="text" class="form-control" name="«f.name.toFirstLower»">
			</div>
			<input type="hidden" name="«f.name.toFirstLower»_LTE" value="{{«f.name.toFirstLower»_LTE}}" />
			'''
            case f.comment.contains("-select"):{
                if(f.comment.split("-").length>2) {
                    var name = f.comment.split("-").get(2).toFirstLower
                    '''
                    <select name="«f.name.toFirstLower»_EQ" class="form-control" ng-model="«name»" ng-options="d.name for d in «name»s"
					data-value="{{«name»}}">
					     <option value="">-- 请选择 --</option>
					</select>
					'''
                }else{
                    '''
                    <select name="«f.name.toFirstLower»_EQ" class="form-control" ng-model="«f.name.toFirstLower»" ng-options="d for d in «f.name.toFirstLower»s"
					data-value="{{«f.name.toFirstLower»}}" «IF f.name.toUpperCase.equals("CITY")»ng-click="getCitys()"«ENDIF»>
					     <option value="">-- 请选择 --</option>
					</select>
					'''
                }
            }
            default:
                '''
                <input type="text" name="«f.name.toFirstLower»_LIKE" ng-model="«t.klassType.toFirstLower».«f.name.toFirstLower»" class="form-control" />
			'''
        }
    }

    def static parseInput(VisonTable t, VisonField f) {
        return switch f.comment {
            case f.comment.contains("-date"):
                '''
                <div class="input-group input-large date-picker input-daterange" data-date-format="yyyy-mm-dd">
                     <input type="text" class="form-control" name="«f.name.toFirstLower»">
				 <span class="input-group-addon">至</span>
				 <input type="text" class="form-control" name="«f.name.toFirstLower»">
			</div>
			'''
            case f.comment.contains("-select"):{
                if(f.comment.split("-").length>2) {
                    var name = f.comment.split("-").get(2).toFirstLower
                    '''
                    <select name="«f.name.toFirstLower»" class="form-control" ng-model="«name»" ng-options="d.name for d in «name»s"
					data-value="{{«name»}}">
					     <option value="">-- 请选择 --</option>
					</select>
					'''
                }else{
                    '''
                    <select name="«f.name.toFirstLower»" class="form-control" ng-model="«f.name.toFirstLower»" ng-options="d for d in «f.name.toFirstLower»s"
					data-value="{{«f.name.toFirstLower»}}"«IF f.name.toUpperCase.equals("CITY")»ng-click="getCitys()"«ENDIF»>
					     <option value="">-- 请选择 --</option>
					</select>
					'''
                }
            }
            default:
                '''
                <input type="text" name="«f.name.toFirstLower»" ng-model="«t.klassType.toFirstLower».«f.name.toFirstLower»" class="form-control" />
			'''
        }
    }

    def static parseFieldAnnotation(VisonField f) {
        return switch f{
            case f.key.toUpperCase.contains("P"):
                '''
                @Id
                private «f.javaType» «f.name.toFirstLower»;
			'''
            case f.javaType.toUpperCase.equals("DATE"):
                '''
                private «f.javaType» «f.name.toFirstLower»;
			'''
            default:'''private «f.javaType» «f.name.toFirstLower»;'''
        }
    }

    @Data
    static class VisonTable {
        String gene
        String klassType
        String klassName
        List<VisonField> fields
    }

    @Data
    static class VisonField {
        String name
        String type
        String require
        String key
        String comment
        String show

        def String javaName() {
            return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name.toLowerCase())
        }

        def String javaType() {
            switch (type.toFirstLower) {
                case "bigint": "Integer"
                case "varchar": "String"
                case "datetime": "Date"
                case "int": "Integer"
                default: type.toFirstUpper
            }
        }

        def defaultValue() {
            switch (type.toFirstLower) {
                case "bigint": "99L"
                case "varchar": '''"SSS"'''
                case "datetime": "new Date()"
                case "date": "new Date()"
                case "int": "99"
                case type.toFirstLower.startsWith("list"):'''new Array«type.toFirstUpper»()'''
                default: '''new «type.toFirstUpper»()'''
            }
        }

    }

}
