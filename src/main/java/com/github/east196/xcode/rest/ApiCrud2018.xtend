package com.github.east196.xcode.rest

import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import java.util.List
import com.github.east196.xcode.model.Three
import com.github.east196.xcode.model.GeneResult
import com.github.east196.xcode.meta.DocMetaParser
import com.google.common.base.CaseFormat
import lombok.Data
import org.boon.Boon

class ApiCrud2018 {

	def static void main(String[] args) {
		// print(toValid('''{"r":true,"v":address}''').requried)
		new DocMetaParser().action('''E:\backup\xcode\统一数据文档 Pro.doc''').filter [ three |
			three.record.geneOk.trim == ""
		].forEach [ three |
			geneAll(three)
		]
	}

	def static toValid(String validStr) {
		Valid.from(validStr)
	}

	def static toJson(Valid valid) {
		Boon.toPrettyJson(valid)
	}

	def static geneAll(Three three) {
		gene(three, "entity").copy
		gene(three, "crudservice").copy
		gene(three, "crudserviceimpl").copy
		gene(three, "service").copy
		gene(three, "serviceimpl").copy
		gene(three, "dao").copy
		gene(three, "customdao").copy
		gene(three, "customdaoimpl").copy
		gene(three, "controller").copy
		gene(three, "coustomcontroller").copy
		gene(three, "restcli").copy
	}

	def static gene(Three three, String type) {

		var Project project = three.project
		var Record record = three.record
		var List<Field> fields = three.fields
		val javaPath = project.root.split("\\.").join("\\")
		var packageName = record.name.toFirstLower
		var CharSequence content = ""
		var CharSequence path = ""
		switch type {
			case "entity": {
				content = entity(project, record, fields);
				path = '''«project.path»\src\main\java\«javaPath»\entity\«record.name.toFirstUpper».java'''
			}
			case "dao": {
				content = dao(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\dao\«record.name.toFirstUpper»Repository.java'''

			}
			case "customdao": {
				content = customdao(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\customdao\Customized«record.name.toFirstUpper»Repository.java'''

			}
			case "customdaoimpl": {
				content = customdaoimpl(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\customdaoimpl\Customized«record.name.toFirstUpper»RepositoryImpl.java'''

			}
			case "controller": {
				content = controller(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\controller\«record.name.toFirstUpper»CrudController.java'''

			}
			case "restcli": {
				content = restcli(project, record, fields)
				path = '''«project.path»\src\main\java\«javaPath»\restcli\«record.name.toFirstUpper»Cli.java'''

			}
			case "service": {
				content = Service(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\service\«record.name.toFirstUpper»Service.java'''
			}
			case "serviceimpl": {
				content = ServiceImpl(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\serviceimpl\«record.name.toFirstUpper»ServiceImpl.java'''
			}
			case "crudservice": {
				content = CrudService(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\crudservice\«record.name.toFirstUpper»CrudService.java'''
			}
			case "crudserviceimpl": {
				content = CrudServiceImpl(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\crudserviceimpl\«record.name.toFirstUpper»CrudServiceImpl.java'''
			}
			case "coustomcontroller": {
				content = CoustomCon1troller(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\coustomcontroller\«record.name.toFirstUpper»CoustomController.java'''
			}
			default: {
				content = entity(three.project, three.record, three.fields)
				path = '''«project.path»\src\main\java\«javaPath»\entity\«record.name.toFirstUpper».java'''
			}
		}
		return new GeneResult(content, path)
	}

	def static CoustomCon1troller(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var packageName = record.name.toFirstLower
		var klassType = record.name.toFirstUpper
		var serviceType = record.name.toFirstUpper + "Service"
		'''
			package «basePackageName».coustomcontroller;
			
			import org.slf4j.Logger;
			import org.slf4j.LoggerFactory;
			import io.swagger.annotations.Api;
			import org.springframework.web.bind.annotation.RestController;
			import org.springframework.beans.factory.annotation.Autowired;
			
			import «basePackageName».service.*;
			
			@Api("自定义«record.label»管理接口")
			@RestController
			public class «klassType»CoustomController {
				
					private static final Logger LOGGER = LoggerFactory.getLogger(«klassType»CoustomController.class);
				
					@Autowired
					private «serviceType» «serviceType.toFirstLower»;
				
			}
		'''
	}

	def static ServiceImpl(Project project, Record record, List<Field> fields) {
		var klassType = record.name.toFirstUpper
		val basePackageName = project.root
		''' 
			package «basePackageName».serviceimpl;
			
			import org.springframework.stereotype.Service;
			
			import «basePackageName».service.*;
			import «basePackageName».crudserviceimpl.*;
			
			@Service
			public class «klassType»ServiceImpl extends «klassType»CrudServiceImpl implements «klassType»Service {
				
			}
		'''
	}

	def static Service(Project project, Record record, List<Field> fields) {
		var klassType = record.name.toFirstUpper
		val basePackageName = project.root
		''' 
			package «basePackageName».service;
			
			import «basePackageName».crudservice.*;
			
			public interface «klassType»Service extends «klassType»CrudService{
				
			}
		'''
	}

	// service
	def static CrudService(Project project, Record record, List<Field> fields) {
		val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 2).join(".")
		var klassType = record.name.toFirstUpper
		val basePackageName = project.root
		'''
			package «basePackageName».crudservice;
			
			import java.util.List;
			import java.util.Map;
			
			import org.springframework.data.jpa.domain.Specification;
			
			import «commonPackageName».common.vo.DataResponse;
			import «commonPackageName».common.vo.Response;
			import «commonPackageName».common.vo.TableResult;
			import «basePackageName».entity.*;
			
			public interface «klassType»CrudService{
				public List<«klassType»> findAll(Specification<«klassType»> spec);
				public TableResult<List<«klassType»>> findAll(Integer pageNo,Integer pageSize, Map<String, String> queryMap);
				public DataResponse<«klassType»> save(«klassType» «klassType.toFirstLower»);
				public DataResponse<«klassType»> findByEnableId(String id);
				public Response delete(String id);
				public Response deletes(List<String> ids);
			
			}
		'''
	}

	// serviceImpl
	def static CrudServiceImpl(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
		var daoType = record.name.toFirstUpper + "Repository"
		var oldInfo = "old" + klassType + "Info"
		var info = klassType + "Info"
		val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 2).
			join(
				".")
		'''
				package «basePackageName».crudserviceimpl;
						
						import java.util.List;
						import java.util.Map;
						
						import org.springframework.beans.factory.annotation.Autowired;
						import org.springframework.data.domain.Page;
						import org.springframework.data.domain.Sort;
						import org.springframework.data.domain.Sort.Order;
						import org.springframework.data.domain.PageRequest;
						import org.springframework.data.jpa.domain.Specification;
						import org.springframework.stereotype.Service;
						
						import «commonPackageName».common.DynamicSpecifications;
						import «commonPackageName».common.Merger;
						import «commonPackageName».common.SearchFilter;
						import «commonPackageName».common.YjBoon;
						import «commonPackageName».common.vo.DataResponse;
						import «commonPackageName».common.vo.Response;
						import «commonPackageName».common.vo.TableResult;
						import «basePackageName».crudservice.*;
						import «basePackageName».dao.*;
						import «basePackageName».entity.*;
						
						@Service
						public class «klassType»CrudServiceImpl implements «klassType»CrudService{
						
							@Autowired
							private «klassType»Repository «klassType.toFirstLower»Repository;
						
							@Override
							  public List<«klassType»> findAll(Specification<«klassType»> spec) {
							   	    return «klassType.toFirstLower»Repository.findAll(spec);
							   }
				
						    @Override
						    public TableResult<List<«klassType»>> findAll(Integer pageNo,Integer pageSize, Map<String, String> queryMap) {
						    	List<SearchFilter> searchFilters = SearchFilter.fromQueryMap(queryMap, «klassType».class);
						    	searchFilters.add(new SearchFilter("enable", SearchFilter.Operator.EQ,true));
						    	PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize, Sort.by(Order.desc("id")));
						    	Specification<«klassType»> spec = DynamicSpecifications.bySearchFilter(searchFilters, «klassType».class);
						    	Page<«klassType»> «klassType.toFirstLower»s = «daoType.toFirstLower».findAll(spec, pageRequest);
						    	TableResult<List<«klassType»>> tableResult = new TableResult<List<«klassType»>>();
						    	tableResult.setPageNo(«klassType.toFirstLower»s.getNumber()+1);
						    	tableResult.setPageSize(«klassType.toFirstLower»s.getSize());
						    	tableResult.setTotalCount(«klassType.toFirstLower»s.getTotalElements());
						    	tableResult.setTotalPage(«klassType.toFirstLower»s.getTotalPages());
						    	tableResult.setData(«klassType.toFirstLower»s.getContent());
						    	return tableResult;
						    }
				
						    @Override
						    public DataResponse<«klassType»> save(«klassType» «klassType.toFirstLower») {
						         «klassType» saveInfo;
						         if(YjBoon.isEmpty(«klassType.toFirstLower».getId())){
						         	«klassType.toFirstLower».setEnable(true);
						         	  saveInfo= «daoType.toFirstLower».save(«klassType.toFirstLower»);
						         }else{
						            «klassType» «oldInfo» = «daoType.toFirstLower».findByIdAndEnableIsTrue(«klassType.toFirstLower».getId());
						            «klassType.toFirstLower» = Merger.mergeNotNullToFirst(«oldInfo», «klassType.toFirstLower»);
						            saveInfo= «daoType.toFirstLower».save(«klassType.toFirstLower»);
						         }
						         if(YjBoon.isEmpty(saveInfo)){
						            return new DataResponse<>("-1","error");
						         }
						        return new DataResponse<>("0","OK",saveInfo);
						    }
						    
						    @Override
						    public DataResponse<«klassType»> findByEnableId(String id){
						    	«klassType» «info»=«daoType.toFirstLower».findByIdAndEnableIsTrue(id);
						    	if(YjBoon.isEmpty(«info»)){
						    		return new DataResponse<>("-1","error");
						    	}
						    	return new DataResponse<>("0","OK",«info»);
						    }
						    @Override
						    public Response delete(String id) {
						         Integer res=«daoType.toFirstLower».updateEnableStatus(id);
						         if(YjBoon.isEmpty(res)){
						         	return new DataResponse<>("-1","删除失败");
						         }
						       return new DataResponse<>("0","OK",res);
						    }
						    
						    @Override
						    public Response deletes(List<String> ids) {
						    	Integer res=«daoType.toFirstLower».updateEnableStatusBacth(ids);
						    	if(res==ids.size()){
						    		return new DataResponse<>("0","OK",res);
						    	}
						    	return new DataResponse<>("-1","删除失败");
						    }
						}
			'''
		}

		def static entity(Project project, Record record, List<Field> fields) {
			val basePackageName = project.root
			var klassType = record.name.toFirstUpper
			var packageName = record.name.toFirstLower
			var beanName = record.name.toFirstLower
			val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 2).
			join(
				".")
			'''
package «basePackageName».entity;

import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import «basePackageName».entity.*;
import «commonPackageName».common.*;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude={«FOR f : fields»«IF f.keyType=="M21"|| f.keyType =="121"»"«f.name»",«ENDIF»«ENDFOR»}) 
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
@EntityListeners(AuditingEntityListener.class)
public class «klassType» {

«FOR f : fields»

	/**«f.doc»**/
	«IF f.getKeyType=="P"»
	@Id
	@GenericGenerator(name="system-uuid", strategy="uuid") //这个是hibernate的注解/生成32位UUID
	@GeneratedValue(generator="system-uuid")
	@Column(length = 32)
	«ELSEIF f.getKeyType=="M21"»
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"«beanName»s"})
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@NotFound(action= NotFoundAction.IGNORE)
	«ELSEIF f.getKeyType=="12M"»
	@Transient
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"«beanName»"})
	@OneToMany(fetch=FetchType.LAZY,mappedBy="«beanName»",orphanRemoval=false)
	@NotFound(action= NotFoundAction.IGNORE)
	«ELSEIF f.getKeyType=="121"»
	@OneToOne(fetch=FetchType.EAGER)
	@NotFound(action= NotFoundAction.IGNORE)
	«ENDIF»
	«IF f.type=="date"»
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    «IF f.name.contains("createTime")»@CreatedDate«ENDIF»
    «IF f.name.contains("modifyTime")»@LastModifiedDate«ENDIF»
	«ELSEIF f.type=="datetime"»
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    «IF f.name.contains("createTime")»@CreatedDate«ENDIF»
    «IF f.name.contains("modifyTime")»@LastModifiedDate«ENDIF»
	«ENDIF»
	«IF f.valid.toValid.requried==true»
	«IF f.javaType=="List"»
	@NotEmpty(message ="«f.doc»列表不能为空")
	«ENDIF»
	@NotNull(message ="«f.doc»不能为空")
	«ENDIF»
	«IF f.valid.toValid.valid=="cname"»
	@Pattern(regexp = Validators.REGEX_CHINESE_LENGTH ,message = "姓名应当使用汉字！并且长度应当在2至8个汉字之间！")
	«ELSEIF f.valid.toValid.valid=="ename"»
	@Pattern(regexp = Validators.REGEX_USERNAME_PLUS ,message = "用户名应当使用英文数字！并且长度应当在4至10个汉字之间！")
	«ELSEIF f.valid.toValid.valid=="name"»
	@Pattern(regexp = Validators.REGEX_CHINESE_OR_ENGLISH_OR_NUMBER ,message = "名称应当使用汉字英文数字！并且长度应当在2至40个汉字之间！")
	«ELSEIF f.valid.toValid.valid=="address"»
	@Pattern(regexp = Validators.REGEX_CHINESE_OR_ENGLISH_OR_NUMBER ,message = "地址应当使用中文、英文、数字！并且长度应当在2至40个汉字之间！")
	«ELSEIF f.valid.toValid.valid=="phone"»
	@Pattern(regexp = Validators.REGEX_MOBILE ,message = "手机号码格式不对！")
	«ELSEIF f.valid.toValid.valid=="password"»
	@Pattern(regexp = Validators.REGEX_ENGLISH_OR_NUMBER_LENGTH ,message = "密码应当为英文、数字，并且长度在6-12位之间！")
	«ELSEIF f.valid.toValid.valid=="path"»
	@Pattern(regexp = Validators.REGEX_PATH ,message = "路径应该格式正确！！")
	«ENDIF»
	private «f.javaType» «f.name.toFirstLower»;
	«ENDFOR»
}
		'''
		}

		def static customdao(Project project, Record record, List<Field> fields) {
			val basePackageName = project.root
			var daoType = record.name.toFirstUpper + "Repository"
			var packageName = record.name.toFirstLower
			'''
package «basePackageName».customdao;

import java.util.List;

public interface Customized«daoType» {
	
}
		'''
		}

		def static customdaoimpl(Project project, Record record, List<Field> fields) {
			val basePackageName = project.root
			var daoType = record.name.toFirstUpper + "Repository"
			var packageName = record.name.toFirstLower
			'''
package «basePackageName».customdaoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import «basePackageName».customdao.*;

public class Customized«daoType»Impl implements Customized«daoType»  {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
}
		'''
		}

		def static dao(Project project, Record record, List<Field> fields) {
			val basePackageName = project.root
			var beanType = record.name.toFirstUpper
			var daoType = record.name.toFirstUpper + "Repository"
			var packageName = record.name.toFirstLower
			var tableName = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,
				record.
					name)
					'''
package «basePackageName».dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import «basePackageName».entity.*;
import «basePackageName».customdao.*;

public interface «daoType» extends JpaRepository<«beanType», String>, JpaSpecificationExecutor<«beanType»>, Customized«daoType»{
	
	«FOR f : fields»
	«IF f.getKeyType=="U"»
	public «beanType» findBy«f.name.toFirstUpper»AndEnableIsTrue(«f.javaType» «f.name»);
	«ENDIF»
	«ENDFOR»
	
	public «beanType» findByIdAndEnableIsTrue(String id);
	
	@Transactional
	@Modifying
	@Query(value = "update «tableName» set enable = 0 where id = ?1",nativeQuery = true)
	public Integer updateEnableStatus(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "update «tableName» set enable = 0 where id in (:ids)",nativeQuery = true)
	public Integer updateEnableStatusBacth(List<String> ids);
	// add more ...
}
		'''
				}

				def static controller(Project project, Record record, List<Field> fields) {
					val basePackageName = project.root
					val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 2).
						join(".")
					var beanType = record.name.toFirstUpper
					var serviceType = record.name.toFirstUpper + "Service"
					var klassType = record.name.toFirstUpper + "CrudController"
					var packageName = record.name.
						toFirstLower
					'''
package «basePackageName».controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
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

import «commonPackageName».common.DynamicSpecifications;
import «commonPackageName».common.SearchFilter;
import «commonPackageName».common.vo.DataResponse;
import «commonPackageName».common.vo.Response;
import «commonPackageName».common.vo.TableResult;
import «basePackageName».service.*;
import «basePackageName».entity.*;

@Api("«record.label»管理接口")
@RestController
@RequestMapping("/crud/v1/«beanType.toFirstLower»")
public class «klassType» {

	private static final Logger LOGGER = LoggerFactory.getLogger(«klassType».class);

	@Autowired
	private «serviceType» «serviceType.toFirstLower»;
	
	@ApiOperation(value = "查询«record.label»信息")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public DataResponse<List<«beanType»>> search(HttpServletRequest request) {
		Map<String, String[]> requestParameterMap = request.getParameterMap();
		List<SearchFilter> searchFilters = SearchFilter.from(requestParameterMap, «klassType».class);
		searchFilters.add(new SearchFilter("enable", SearchFilter.Operator.EQ, true));
		Specification<«beanType»> spec = DynamicSpecifications.bySearchFilter(searchFilters, «beanType».class);
		List<«beanType»> «beanType.toFirstLower»s = «serviceType.toFirstLower».findAll(spec);
		return new DataResponse<List<«beanType»>>("0", "查询成功!", «beanType.toFirstLower»s);
	}
	
	@ApiOperation(value = "分页查询«record.label»")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo",value = "页码",paramType ="query", required = false,dataType = "Integer",defaultValue = "1"),
			@ApiImplicitParam(name = "pageSize",value = "每页显示条数",paramType ="query",required = false,dataType = "Integer",defaultValue = "20"),
			@ApiImplicitParam(name = "queryMap",value = "查询条件",paramType ="body",required = false,dataType = "Map")
	})
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public DataResponse<TableResult<List<«beanType»>>> page(
	@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
	@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
	@RequestBody Map<String, String> queryMap) {
		TableResult<List<«beanType»>> tableResult = «serviceType.toFirstLower».findAll(pageNo, pageSize,queryMap);
		return new DataResponse<TableResult<List<«beanType»>>>("0", "查询成功!", tableResult);
	}	
	
	
	@ApiOperation(value = "新建 «record.label»信息")
	@ApiImplicitParam(name = "«beanType.toFirstLower»",value = "«record.label»对象", required = true, paramType = "body",dataType = "«beanType»")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public DataResponse<«beanType»> create(@RequestBody @Valid «beanType» «beanType.toFirstLower», BindingResult result) {
		LOGGER.debug("add «beanType.toFirstLower»:  {}", «beanType.toFirstLower»);
		if (result.hasErrors()) {
			StringBuffer sb = new StringBuffer();
			for (ObjectError msg : result.getAllErrors())
				sb.append(msg.getDefaultMessage()).append(" ");
			return new DataResponse<«beanType»>("-1", sb.toString());
		}
	    return «serviceType.toFirstLower».save(«beanType.toFirstLower»);
	}
	
	@ApiOperation(value = "编辑 «record.label»信息")
	@ApiImplicitParam(name = "«beanType.toFirstLower»",value = "«record.label»对象", required = true, paramType = "body",dataType = "«beanType»")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public DataResponse<«beanType»> update(@RequestBody @Valid «beanType» «beanType.toFirstLower», BindingResult result) {
		LOGGER.debug("add «beanType.toFirstLower»:  {}", «beanType.toFirstLower»);
		if (result.hasErrors()) {
			StringBuffer sb = new StringBuffer();
			for (ObjectError msg : result.getAllErrors())
				sb.append(msg.getDefaultMessage()).append(" ");
			return new DataResponse<«beanType»>("-1", sb.toString());
		}
	    return «serviceType.toFirstLower».save(«beanType.toFirstLower»);
	}

	@ApiOperation(value = "根据ID获取 «record.label»信息")
	@ApiImplicitParam(name="id",value = " «record.label»ID",required = true,paramType = "path",dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DataResponse<«beanType»> get(@PathVariable("id") String id) {
		LOGGER.debug("id:  {}", id);
		return «serviceType.toFirstLower».findByEnableId(id);
	}

	@ApiOperation(value = "根据ID删除 «record.label»信息")
	@ApiImplicitParam(name="id",value = " «record.label»ID",required = true,paramType = "path",dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response delete(@PathVariable("id") String id) {
		LOGGER.debug("id:  {}", id);
		return «serviceType.toFirstLower».delete(id);
	}

	@ApiOperation(value = "根据ID批量删除«record.label»信息")
	@ApiImplicitParam(name ="ids",value = "id集合",required = true,paramType = "body",dataType = "List")
	@RequestMapping(value = "/deletes", method = RequestMethod.POST)
	public Response «beanType.toFirstLower»Deletes(@RequestBody List<String> ids) {
		LOGGER.debug("ids:  {}", ids);
		return «serviceType.toFirstLower».deletes(ids);
	}
}
		'''
				} // TODO PUT 方法合并对象 

				def static restcli(Project project, Record record, List<Field> fields) {
					val basePackageName = project.root
					val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 2).
						join(".")
					var beanType = record.name.toFirstUpper
					var klassType = record.name.toFirstUpper + "Cli"
					var packageName = record.name.toFirstLower
					'''
package «basePackageName».restcli;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import «commonPackageName».common.vo.DataResponse;
import «commonPackageName».common.vo.Response;
import «commonPackageName».common.vo.TableResult;

import «basePackageName».entity.*;


@FeignClient(url = "${feign.restcli.request.url}/controller/v1/«beanType.toFirstLower»", name = "«beanType.toFirstLower»Cli")
public interface «klassType» {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public DataResponse<List<«beanType»>> all();
	
	@RequestMapping(value = "/page", method = RequestMethod.POST)
	public DataResponse<TableResult<List<«beanType»>>> page(
	@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
	@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize,
	@RequestBody Map<String, String> queryMap);
	

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Response create(@RequestBody «beanType» «beanType.toFirstLower»);
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public Response update(@RequestBody «beanType» «beanType.toFirstLower»);

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response delete(@PathVariable("id") String id);

	@RequestMapping(value = "/deletes", method = RequestMethod.POST)
	public Response «beanType.toFirstLower»Deletes(@RequestBody List<String> ids);

}
		'''
				} // TODO PUT 方法合并对象 
				
					@Data
	static class Valid {
		boolean r = false
		String v

		def static from(String validStr) {
			Boon.fromJson(validStr, Valid)
		}

		def getRequried() {
			r
		}

		def getValid() {
			v
		}
	}
			}
			