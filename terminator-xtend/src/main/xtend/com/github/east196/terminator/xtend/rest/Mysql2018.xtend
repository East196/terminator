package com.github.east196.terminator.xtend.rest

import com.github.east196.terminator.xtend.meta.DocMetaParser
import com.github.east196.terminator.xtend.model.Field
import com.github.east196.terminator.xtend.model.GeneResult
import com.github.east196.terminator.xtend.model.Project
import com.github.east196.terminator.xtend.model.Record
import com.github.east196.terminator.xtend.model.Three
import com.google.common.base.CaseFormat
import java.util.List

class Mysql2018 {

	def static void main(String[] args) {
		new DocMetaParser().action('''E:\backup\xcode\uniondata2019demo.doc''').filter [ three |
			three.record.geneOk.trim == ""
		].forEach [ three |
			println(111)
			geneAll(three)
		]
	}

	def static geneAll(Three three) {
		gene(three, "entity").copy
		gene(three, "dao").copy
		gene(three, "customdao").copy
		gene(three, "customdaoimpl").copy
		gene(three, "controller").copy
		gene(three, "restcli").copy
		gene(three, "validator").copy
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
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper».java'''
			}
			case "dao": {
				content = dao(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper»Repository.java'''

			}
			case "customdao": {
				content = customdao(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\Customized«record.name.toFirstUpper»Repository.java'''

			}
			case "customdaoimpl": {
				content = customdaoimpl(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\Customized«record.name.toFirstUpper»RepositoryImpl.java'''

			}
			case "controller": {
				content = controller(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper»Controller.java'''

			}
			case "restcli": {
				content = restcli(project, record, fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper»Cli.java'''

			}
			case "validator": {
				content = validator(project, record,
					fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper»Validator.java'''
			}
			default: {
				content = entity(three.project, three.record, three.fields)
				path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper».java'''
			}
		}
		return new GeneResult(content, path)
	}

	def static entity(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
		var packageName = record.name.toFirstLower
		var beanName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

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
«FOR f : fields»
«IF f.getKeyType=="M21"»
import «basePackageName».«f.javaType.toFirstLower».«f.javaType»;
«ENDIF»
«IF f.getKeyType=="12M"»
import «basePackageName».«f.javaType.toFirstLower».«f.javaType»;
«ENDIF»
«IF f.getKeyType=="121"»
import «basePackageName».«f.javaType.toFirstLower».«f.javaType»;
«ENDIF»
«ENDFOR»
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
	private «f.javaType» «f.name.toFirstLower»;
	«ELSEIF f.getKeyType=="M21"»
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"«beanName»s"})
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@NotFound(action= NotFoundAction.IGNORE)
	private «f.javaType» «f.name.toFirstLower»;
	«ELSEIF f.getKeyType=="12M"»
	@Transient
	@JsonIgnoreProperties(ignoreUnknown = true, value = {"«beanName»"})
	@OneToMany(fetch=FetchType.LAZY,mappedBy="«beanName»",orphanRemoval=false)
	@NotFound(action= NotFoundAction.IGNORE)
	private List<«f.javaType»> «f.name.toFirstLower»;
	«ELSEIF f.getKeyType=="121"»
	@OneToOne(fetch=FetchType.EAGER)
	@NotFound(action= NotFoundAction.IGNORE)
	private «f.javaType» «f.name.toFirstLower»;
	«ELSEIF f.type=="date"»
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    «IF f.name.contains("createTime")»@CreatedDate«ENDIF»
    «IF f.name.contains("modifyTime")»@LastModifiedDate«ENDIF»
	private «f.javaType» «f.name.toFirstLower»;
	«ELSEIF f.type=="datetime"»
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    «IF f.name.contains("createTime")»@CreatedDate«ENDIF»
    «IF f.name.contains("modifyTime")»@LastModifiedDate«ENDIF»
	private «f.javaType» «f.name.toFirstLower»;
	«ELSE»
	private «f.javaType» «f.name.toFirstLower»;
	«ENDIF»
	
	«ENDFOR»

}
		'''
	}

	def static customdao(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var daoType = record.name.toFirstUpper + "Repository"
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import java.util.List;

interface Customized«daoType» {
	
}
		'''
	}

	def static customdaoimpl(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var daoType = record.name.toFirstUpper + "Repository"
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

class Customized«daoType»Impl implements Customized«daoType»  {
	
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
package «basePackageName».«packageName»;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface «daoType» extends JpaRepository<«beanType», String>, JpaSpecificationExecutor<«beanType»>, Customized«daoType»{
	
	«FOR f : fields»
	«IF f.getKeyType=="U"»
	public «beanType» findBy«f.name.toFirstUpper»(«f.javaType» «f.name»);
	«ENDIF»
	«ENDFOR»
	
	@Transactional
	@Modifying
	@Query(value = "update «tableName» set enable = 0 where id = ?1",nativeQuery = true)
	public void updateEnableStatus(String id);
	
	
	@Transactional
	@Modifying
	@Query(value = "update «tableName» set enable = 0 where id in (:ids)",nativeQuery = true)
	public void updateEnableStatusBacth(List<String> ids);
	// add more ...
}
		'''
			}

			def static controller(Project project, Record record, List<Field> fields) {
				val basePackageName = project.root
				val commonPackageName = project.root.split("\\.").subList(0, project.root.split("\\.").length - 2).
					join(".")
				var beanType = record.name.toFirstUpper
				var daoType = record.name.toFirstUpper + "Repository"
				var klassType = record.name.toFirstUpper + "Controller"
				var packageName = record.name.
					toFirstLower
				'''
package «basePackageName».«packageName»;

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
import «commonPackageName».common.Merger;
import «commonPackageName».common.SearchFilter;
import «commonPackageName».common.vo.DataResponse;
import «commonPackageName».common.vo.Response;
import «commonPackageName».common.vo.TableResult;

@Api("«record.label»管理接口")
@RestController
@RequestMapping("/controller/v1/«beanType.toFirstLower»")
public class «klassType» {

	private static final Logger LOGGER = LoggerFactory.getLogger(«klassType».class);

	@Autowired
	private «daoType» «daoType.toFirstLower»;
	
	@ApiOperation(value = "查询«record.label»信息")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public DataResponse<List<«beanType»>> search(HttpServletRequest request) {
		Map<String, String[]> requestParameterMap = request.getParameterMap();
		List<SearchFilter> searchFilters = SearchFilter.from(requestParameterMap, «klassType».class);
		Specification<«beanType»> spec = DynamicSpecifications.bySearchFilter(searchFilters, «beanType».class);
		List<«beanType»> «beanType.toFirstLower»s = «daoType.toFirstLower».findAll(spec);
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
		List<SearchFilter> searchFilters = SearchFilter.fromQueryMap(queryMap, «beanType».class);
		searchFilters.add(new SearchFilter("enable", SearchFilter.Operator.EQ,true));
		PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize, Sort.by(Order.desc("id")));
    	Specification<«beanType»> spec = DynamicSpecifications.bySearchFilter(searchFilters, «beanType».class);
		Page<«beanType»> «beanType.toFirstLower»s = «daoType.toFirstLower».findAll(spec, pageRequest);
		TableResult<List<«beanType»>> tableResult = new TableResult<List<«beanType»>>();
		tableResult.setPageNo(«beanType.toFirstLower»s.getNumber()+1);
		tableResult.setPageSize(«beanType.toFirstLower»s.getSize());
		tableResult.setTotalCount(«beanType.toFirstLower»s.getTotalElements());
		tableResult.setTotalPage(«beanType.toFirstLower»s.getTotalPages());
		tableResult.setData(«beanType.toFirstLower»s.getContent());
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
		«IF fields.filter[it.name=="enable"].toList.size>0»
		«beanType.toFirstLower».setEnable(true);
		«ENDIF»
		«beanType» saved«beanType» = «daoType.toFirstLower».save(«beanType.toFirstLower»);
	    return new DataResponse<«beanType»>("0", "ok", saved«beanType»);
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
        «beanType» old«beanType» = «daoType.toFirstLower».findById(«beanType.toFirstLower».getId()).orElse(null);
        «beanType» new«beanType» = Merger.mergeNotNullToFirst(old«beanType», «beanType.toFirstLower»);
		«beanType» saved«beanType» = «daoType.toFirstLower».save(new«beanType»);
	    return new DataResponse<«beanType»>("0", "ok", saved«beanType»);
	}

	@ApiOperation(value = "根据ID获取 «record.label»信息")
	@ApiImplicitParam(name="id",value = " «record.label»ID",required = true,paramType = "path",dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public DataResponse<«beanType»> get(@PathVariable("id") String id) {
		LOGGER.debug("id:  {}", id);
		Optional<«beanType»> «beanType.toFirstLower» = «daoType.toFirstLower».findById(id);
		return new DataResponse<«beanType»>("0", "ok", «beanType.toFirstLower».orElse(null));
	}

	@ApiOperation(value = "根据ID删除 «record.label»信息")
	@ApiImplicitParam(name="id",value = " «record.label»ID",required = true,paramType = "path",dataType = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response delete(@PathVariable("id") String id) {
		LOGGER.debug("id:  {}", id);
		«daoType.toFirstLower».updateEnableStatus(id);
		return new Response("0", "ok");
	}

	@ApiOperation(value = "根据ID批量删除«record.label»信息")
	@ApiImplicitParam(name ="ids",value = "id集合",required = true,paramType = "body",dataType = "List")
	@RequestMapping(value = "/deletes", method = RequestMethod.POST)
	public Response «beanType.toFirstLower»Deletes(@RequestBody List<String> ids) {
		LOGGER.debug("ids:  {}", ids);
		for (String id : ids) {
			«daoType.toFirstLower».updateEnableStatus(id);
		}
		return new Response("0", "ok");
	}

	@InitBinder("«beanType.toFirstLower»")
	public void initBinder(DataBinder binder) {
		binder.setValidator(new «beanType»Validator());
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
package «basePackageName».«packageName»;

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

			def static validator(Project project, Record record, List<Field> fields) {
				val basePackageName = project.root
				var beanType = record.name.toFirstUpper
				var klassType = record.name.toFirstUpper + "Validator"
				var packageName = record.name.toFirstLower
				'''
package «basePackageName».«packageName»;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class «klassType» implements Validator {

	@Override
	public boolean supports(Class<?> klass) {
		return «beanType».class.equals(klass);
	}

	@Override
	public void validate(Object object, Errors errors) {
		«FOR f : fields.filter[it.required.equals("required")].toList»
		ValidationUtils.rejectIfEmpty(errors, "«f.name.toFirstLower»", null, "«f.label»不能为空！");
		«ENDFOR»
	}

}
	    '''
			}

		}
		