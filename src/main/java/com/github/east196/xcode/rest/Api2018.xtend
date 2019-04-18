package com.github.east196.xcode.rest

import com.github.east196.xcode.bot.Bots
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.GeneResult
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import com.github.east196.xcode.model.Three
import java.util.List
import org.apache.poi.hwpf.usermodel.Table
import org.eclipse.xtend.lib.annotations.Data

class Api2018 {

	def static void main(String[] args) {
		var src = '''E:\backup\xcode\API_ADMIN_NEW.doc'''
		gene(src)
	}

	public def static void gene(String src) {
		val tables = Bots.tables(src)
		println("--表格总数：" + tables.size())

		val projecttable = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("project")].get(0)
		val datatables = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("data")]
		val resttables = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("rest")]

		val projectThree = table2project(projecttable)
		datatables.forEach [ table |
			val three = table2data(projectThree, table)
			three.project = projectThree.project
			threeGene(three).copy
		]

		val httpReqResps = resttables.map [ table |
			println(table.getRow(0).getCell(1).text)
			val rest = table2rest(projectThree.project, table)
			rest
		].toList

		httpReqResps.forEach [ rest |
			var Three project = rest.project

			var Three headers = rest.headers
			geneEntity(headers, project)

			var Three params = rest.params
			geneEntity(params, project)

			var Three reqBody = rest.reqBody
			geneEntity(reqBody, project)

			var Three respBody = rest.respBody
			respBody.project = project.project
			threeGene(respBody).copy

		]

		val controllerName = projectThree.project.name.toFirstUpper + "Controller"
		val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
		val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower

		var content = retrofit2(projectThree,
			httpReqResps)
		var path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Retrofit2Client.java'''
		new GeneResult(content, path).copy

		content = feign(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»FeignClient.java'''
		new GeneResult(content, path).copy

		content = controller(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Controller.java'''
		new GeneResult(content, path).copy

		content = android(projectThree,
			httpReqResps)
		path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«projectThree.project.name.toFirstUpper»Android.java'''
		new GeneResult(content, path).copy
	}

	protected def static void geneEntity(Three part, Three project) {
		if (part.fields.length > 0) {
			part.project = project.project
			threeGene(part).copy
		}
	}

	protected def static CharSequence threeContent(Three three) {
		var Project project = three.project
		var Record record = three.record
		var List<Field> fields = three.fields
		if (!record.name.endsWith("RespBody") && fields.size == 0) {
			return ''''''
		}
		var content = bean(project, record, fields)
		content
	}

	protected def static CharSequence threePath(Three three) {

		val basePath = three.project.path
		val javaPath = three.project.root.split("\\.").join("\\")
		var packageName = three.project.name.toFirstLower
		var Project project = three.project
		var Record record = three.record
		var List<Field> fields = three.fields
		if (!record.name.endsWith("RespBody") && fields.size == 0) {
			return ''''''
		}
		var path = '''«basePath»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper».java'''
		path
	}

	protected def static GeneResult threeGene(Three three) {
		var content = threeContent(three)
		var path = threePath(three)
		println(path)
		println(content)
		new GeneResult(content, path)
	}

	def static table2rest(Project projectInfo, Table table) {
		var Three project = threeFrom(projectInfo, table)
		var Three headers = threeFrom(table, "Headers")
		var Three params = threeFrom(table, "Params")
		var Three reqBody = threeFrom(table, "ReqBody")
		var Three respBody = threeFrom(table, "RespBody")
		new HttpReqResp(project, headers, params, reqBody, respBody)
	}

	def static Three threeFrom(Project project, Table table) {
		var Record record = recordFrom(table)
		new Three(project, record, null)
	}

	def static Three threeFrom(Table table, String type) {
		var Project project = new Project
		var Record record = recordFrom(table)
		record.name = record.name + type.toFirstUpper
		new Three(project, record, fieldsFrom(table, type))
	}

	def static recordFrom(Table resttable) {
		var record = new Record
		record.method = resttable.getRow(1).getCell(1).text.trim
		record.url = resttable.getRow(2).getCell(1).text.trim
		record.name = resttable.getRow(0).getCell(1).text.trim
		record.label = resttable.getRow(0).getCell(3).text.trim
		record.doc = resttable.getRow(1).getCell(3).text.trim
		record
	}

	def static fieldsFrom(Table resttable, String type) {
		var List<Field> fields = newArrayList()
		for (var j = 3; j < resttable.numRows; j++) {
			var row = resttable.getRow(j)
			var rowType = row.getCell(0).text.trim
			if (rowType.equalsIgnoreCase(type) && !row.getCell(1).text.trim.nullOrEmpty) {
				var field = new Field()
				field.name = row.getCell(1).text.trim
				field.name = field.name.replace(" ", "_").split("_").map[item|item.toFirstUpper].join().toFirstLower
				field.type = row.getCell(2).text.trim
				field.label = row.getCell(3).text.trim
				field.doc = row.getCell(3).text.trim
				fields.add(field)
			}
		}
		fields
	}

	def static bean(Project project, Record record, List<Field> fields) {
		var klassType = record.name.toFirstUpper
		var packageName = project.name.toFirstLower
		val basePackageName = project.root
		val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 1).join(".")

		'''
					package «basePackageName».«packageName»;
			
			import java.util.List;
			import java.util.Date;
			import java.util.HashMap;
			import java.util.Map;
			
			import lombok.Data;
			
			import «commonPackageName».common.Converts;
			import «commonPackageName».common.vo.*;
			
			@Data
			public class «klassType» {
			
			«FOR f : fields»
				/**«f.doc»**/
				private «f.javaType» «f.name.toFirstLower»;	
			«ENDFOR»
			
			public Map<String,Object> toMap(){
				Map<String,Object> map = new HashMap<>();
				«FOR f : fields»
					map.put("«f.name.toFirstLower»",«f.name.toFirstLower»);	
				«ENDFOR»
				return map;
			}
			
			public static «klassType» fromMap(Map<String,Object> map){
				«klassType» «klassType.toFirstLower» = new «klassType»();
				«FOR f : fields»
					«klassType.toFirstLower».set«f.name.toFirstUpper»(Converts.to«f.javaType»(map.get("«f.name.toFirstLower»")));
				«ENDFOR»
				return «klassType.toFirstLower»;
			}
			
			}
			'''
	}

	def static retrofit2(Three projectThree, List<HttpReqResp> httpReqResps) {
		val controllerName = projectThree.project.name.toFirstUpper + "Controller"
		val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
		val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower
		val basePackageName = projectThree.project.root
		val commonPackageName = projectThree.project.root.split("\\.").subList(0,
			projectThree.project.root.split("\\.").length - 1).join(".")

		'''
			package «basePackageName».«packageName»;
			
			«IF httpReqResps.exists[it.respBody.record.method=="GET"]»import retrofit2.http.GET;«ENDIF»
			«IF httpReqResps.exists[it.respBody.record.method=="POST"]»import retrofit2.http.POST;«ENDIF»
			import retrofit2.http.Query;
			import retrofit2.http.QueryMap;
			import retrofit2.http.Body;
			
			import java.util.Map;
			import java.util.Date;
			import java.util.List;
			
			import «commonPackageName».common.vo.*;
			
			
			public interface «retrofit2Name» {
				
			«FOR http : httpReqResps»
				/** «http.respBody.record.label» */
				@«http.respBody.record.method»("«http.respBody.record.url»")
				DataResponse<«http.respBody.record.name.toFirstUpper»> «http.respBody.record.name.replace("RespBody","").toFirstLower»(
				«FOR f : http.params.fields SEPARATOR ","»@Query("«f.javaName»")«f.javaType.toFirstUpper» «f.javaName»
				«ENDFOR»«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»			
				«IF http.reqBody.fields.size>0»@Body «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
				);
				
				«IF http.params.fields.size > 0»
					/** «http.respBody.record.label» */
					@«http.respBody.record.method»("«http.respBody.record.url»")
					«IF http.reqBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
					«IF http.params.fields.size > 0»@QueryMap Map<String,Object> queryMap«ENDIF»«IF http.params.fields.size > 0 && http.reqBody.fields.size>0»,«ENDIF»
					«IF http.reqBody.fields.size>0»@Body «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
					);
				«ENDIF»
			«ENDFOR»
			}
		'''
	}

	def static feign(Three projectThree, List<HttpReqResp> httpReqResps) {
		val controllerName = projectThree.project.name.toFirstUpper + "Controller"
		val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
		val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower
		val basePackageName = projectThree.project.root
		val commonPackageName = projectThree.project.root.split("\\.").subList(0,
			projectThree.project.root.split("\\.").length - 1).join(".")

		'''
			package «basePackageName».«packageName»;
			
			import java.util.Date;
			import java.util.List;
			import java.util.Map;
			
			import org.springframework.cloud.openfeign.FeignClient;
			import org.springframework.web.bind.annotation.PathVariable;
			import org.springframework.web.bind.annotation.RequestBody;
			import org.springframework.web.bind.annotation.RequestMapping;
			import org.springframework.web.bind.annotation.RequestMethod;
			import org.springframework.web.bind.annotation.RequestParam;
			
			import «commonPackageName».common.vo.*;
			
			@FeignClient(url = "${feign.restcli.request.url}/", name = "«feignName.toFirstLower»")
			public interface «feignName» {
				
			«FOR http : httpReqResps»
				/** «http.respBody.record.label» */
				@RequestMapping(value="«http.respBody.record.url»",method=RequestMethod.«http.respBody.record.method.toUpperCase»)
				DataResponse<«http.respBody.record.name.toFirstUpper»> «http.respBody.record.name.replace("RespBody","").toFirstLower»(
				«FOR f : http.params.fields SEPARATOR ","»@RequestParam("«f.javaName»")«f.javaType.toFirstUpper» «f.javaName»
				«ENDFOR»«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»		
				«IF http.reqBody.fields.size>0»@RequestBody «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
				);
				
				«IF http.params.fields.size > 0»
					/** «http.respBody.record.label» */
					@RequestMapping(value="«http.respBody.record.url»",method=RequestMethod.«http.respBody.record.method.toUpperCase»)
					«IF http.reqBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
					«IF http.params.fields.size > 0»Map<String,Object> queryMap«ENDIF»«IF http.params.fields.size > 0 && http.reqBody.fields.size>0»,«ENDIF»
					«IF http.reqBody.fields.size>0»@RequestBody «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
					);
				«ENDIF»
			«ENDFOR»
			}
		'''
	}

	def static controller(Three projectThree, List<HttpReqResp> httpReqResps) {
		val controllerName = projectThree.project.name.toFirstUpper + "Controller"
		val feignName = projectThree.project.name.toFirstUpper + "FeignClient"
		val retrofit2Name = projectThree.project.name.toFirstUpper + "Retrofit2Client"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower
		val basePackageName = projectThree.project.root
		val commonPackageName = projectThree.project.root.split("\\.").subList(0,
			projectThree.project.root.split("\\.").length - 1).join(".")

		'''
			package «basePackageName».«packageName»;
			
			import java.util.Date;
			import java.util.List;
			import java.util.Map;
			
			import org.springframework.web.bind.annotation.PathVariable;
			import org.springframework.web.bind.annotation.RequestBody;
			import org.springframework.web.bind.annotation.RequestMapping;
			import org.springframework.web.bind.annotation.RequestMethod;
			import org.springframework.web.bind.annotation.RequestParam;
			import org.springframework.web.bind.annotation.RestController;
			
			import «commonPackageName».common.vo.*;
			
			@RestController
			public class «controllerName» {
				
			«FOR http : httpReqResps»
				/** «http.respBody.record.label» */
				@RequestMapping(value="«http.respBody.record.url»",method=RequestMethod.«http.respBody.record.method.toUpperCase»)
				DataResponse<«http.respBody.record.name.toFirstUpper»> «http.respBody.record.name.replace("RespBody","").toFirstLower»(
				«FOR f : http.params.fields SEPARATOR ","»@RequestParam("«f.javaName»")«f.javaType.toFirstUpper» «f.javaName»
				«ENDFOR»«IF http.reqBody.fields.size>0 && http.params.fields.size>0»,«ENDIF»
				«IF http.reqBody.fields.size>0»@RequestBody «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
				){
					return new DataResponse<«http.respBody.record.name.toFirstUpper»>();
				}
				
				«IF http.params.fields.size > 0»
					/** «http.respBody.record.label» */
					@RequestMapping(value="«http.respBody.record.url»",method=RequestMethod.«http.respBody.record.method.toUpperCase»)
					«IF http.reqBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>«ELSE»Response«ENDIF» «http.respBody.record.name.replace("RespBody","").toFirstLower»(
					«IF http.params.fields.size > 0»Map<String,Object> queryMap«ENDIF»«IF http.params.fields.size > 0 && http.reqBody.fields.size>0»,«ENDIF»
					«IF http.reqBody.fields.size>0»@RequestBody «http.reqBody.record.name.toFirstUpper» «http.reqBody.record.name.toFirstLower»«ENDIF»
					){
						return new «IF http.reqBody.fields.size>0»DataResponse<«http.respBody.record.name.toFirstUpper»>«ELSE»Response«ENDIF»();
					}
				«ENDIF»
			«ENDFOR»
			}
		'''
	}

	def static android(Three projectThree, List<HttpReqResp> httpReqResps) {
		val HttpsName = projectThree.project.name.toFirstUpper + "Android"
		val basePath = projectThree.project.path
		val javaPath = projectThree.project.root.split("\\.").join("\\")
		var packageName = projectThree.project.name.toFirstLower
		val basePackageName = projectThree.project.root
		val commonPackageName = projectThree.project.root.split("\\.").subList(0,
			projectThree.project.root.split("\\.").length - 1).join(".")

		'''
			package «basePackageName».«packageName»;
			
			import com.google.gson.Gson;
			import com.google.gson.reflect.TypeToken;
			
			import com.yjupi.firewall.NetWork.HttpCaller;
			import com.yjupi.firewall.NetWork.OkHttpCallback;
			import com.yjupi.firewall.NetWork.Url;
			import com.yjupi.firewall.Utils.Utils;
			import com.yjupi.firewall.Entity.MessageEvent;
			import com.yjupi.firewall.Entity.ResponseObj;
			
			import org.greenrobot.eventbus.EventBus;
			import org.greenrobot.eventbus.Subscribe;
			import org.greenrobot.eventbus.ThreadMode;
			
			import java.io.IOException;
			import java.io.InputStream;
			import java.lang.reflect.Type;
			import java.util.ArrayList;
			import java.util.List;
			
			public class «HttpsName» {
				
			«FOR http : httpReqResps»	
				public static final int «http.respBody.record.name.replace("RespBody","").toFirstUpper»_SUCCESS = «httpReqResps.indexOf(http)*2+1»;
				public static final int «http.respBody.record.name.replace("RespBody","").toFirstUpper»_FAIL = «httpReqResps.indexOf(http)*2+2»;
			«ENDFOR»
			
				
			«FOR http : httpReqResps»
				public void «http.respBody.record.method.toLowerCase.toFirstUpper»«http.respBody.record.name.replace("RespBody","").toFirstUpper»() {
				    Type type = new TypeToken<«http.respBody.record.name.toFirstUpper»>() {}.getType();
				    Type mType=Utils.type(ResponseObj.class, type);
				    HttpCaller.getInstance().«http.respBody.record.method.toLowerCase.toFirstUpper»(Url.getBaseUrl() + "«http.respBody.record.url»", mType, new OkHttpCallback() {
				        @Override
				        public void onFailure(int code) {
				            MessageEvent messageEvent=new MessageEvent(null);
				            messageEvent.setId(«http.respBody.record.name.replace("RespBody","").toFirstUpper»_SUCCESS);
				            messageEvent.setName(TagName);
				            EventBus.getDefault().post(messageEvent);
				        }
				        @Override
				        public void onResponse(int code, Object obj) {
				            MessageEvent messageEvent = new  MessageEvent(obj);
				            messageEvent.setId(«http.respBody.record.name.replace("RespBody","").toFirstUpper»_FAIL);
				            messageEvent.setName(TagName);
				            EventBus.getDefault().post(messageEvent);
				            //  }
				        }
				    });
				}
			«ENDFOR»
			}
		'''
	}

	@Data
	static class HttpReqResp {
		Three project
		Three headers
		Three params
		Three reqBody
		Three respBody
	}

	def static table2data(Three projectThree, Table table) {
		var Project project = projectThree.project
		var recordRow = table.getRow(0)
		var Record record = new Record
		record.name = recordRow.getCell(1).text.trim
		record.label = recordRow.getCell(3).text.trim

		var List<Field> fields = newArrayList()
		for (var j = 2; j < table.numRows; j++) {
			var row = table.getRow(j)
			if (!row.getCell(1).text.trim.nullOrEmpty) {
				var field = new Field()
				field.label = row.getCell(0).text.trim
				field.name = row.getCell(1).text.trim
				field.name = field.name.replace(" ", "_").split("_").map[item|item.toFirstUpper].join().toFirstLower
				field.type = row.getCell(2).text.trim
				field.doc = row.getCell(3).text.trim
				fields.add(field)
			}

		}
		new Three(project, record, fields)
	}

	def static table2project(Table projectTable) {
		val projectRow = projectTable.getRow(3)
		var project = new Project
		project.version = projectRow.getCell(0).text.trim
		project.name = projectRow.getCell(1).text.trim
		project.label = projectRow.getCell(2).text.trim
		project.path = projectRow.getCell(3).text.trim
		project.root = projectRow.getCell(4).text.trim
		project.port = projectRow.getCell(5).text.trim

		val webRow = projectTable.getRow(4)
		project.webPath = webRow.getCell(3).text.trim
		project.webRoot = webRow.getCell(4).text.trim

		val androidRow = projectTable.getRow(5)
		project.androidPath = webRow.getCell(3).text.trim
		project.androidRoot = webRow.getCell(4).text.trim
		println(project)

		new Three(project, null, null)
	}
}
