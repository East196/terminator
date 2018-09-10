package com.github.east196.xcode

import java.util.List
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import com.github.east196.xcode.model.Field

class Mongo {
	def static bean(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

«IF fields.exists[f|f.dataType.equals("repeated")]»
import java.util.List;
«ENDIF»
«IF fields.exists[f|f.dataType.equals("datetime")]»
import java.util.Date;
«ENDIF»

public class «klassType» {

	«FOR f : fields»
	/**«f.description»**/
	«IF f.keyType=="P"»@Id«ENDIF»
	private «f.javaType» «f.name.toFirstLower»;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        «klassType» that = («klassType») o;
        return «FOR f : fields SEPARATOR '&&' AFTER ';'»Objects.equal(«f.name», that.«f.name»)«ENDFOR»
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(«fields.map[it.name].join(", ")»);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)«FOR f : fields».add("«f.name»", «f.name»)«ENDFOR».toString();
    }

}
		'''
	}

	def static dao(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var beanType = record.name.toFirstUpper
		var klassType = record.name.toFirstUpper + "Repository"
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface «klassType» extends MongoRepository<«beanType», String>{
	// add more ...
}
		'''
	}

	def static controller(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var beanType = record.name.toFirstUpper
		var daoType = record.name.toFirstUpper + "Repository"
		var klassType = record.name.toFirstUpper + "Controller"
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import «basePackageName».common.DataResponse;
import «basePackageName».common.Response;

@RestController
@RequestMapping("/controller/v1/«beanType.toFirstLower»")
public class «klassType» {

	private static final Logger LOGGER = LoggerFactory.getLogger(«klassType».class);

	@Autowired
	private «daoType» «daoType.toFirstLower»;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public DataResponse<List<«beanType»>> read() {
		List<«beanType»> «beanType.toFirstLower»s = «daoType.toFirstLower».findAll();
		return new DataResponse<List<«beanType»>>("0", "查询成功!", «beanType.toFirstLower»s);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Response createOrUpdate(@RequestBody @Valid «beanType» «beanType.toFirstLower», BindingResult result) {
		LOGGER.debug("add «beanType.toFirstLower»:  {}", «beanType.toFirstLower»);
		if (result.hasErrors()) {
			StringBuffer sb = new StringBuffer();
			for (ObjectError msg : result.getAllErrors())
				sb.append(msg.getDefaultMessage()).append(" ");
			return new Response("-1", sb.toString());
		} else {
			«daoType.toFirstLower».save(«beanType.toFirstLower»);
		    return new Response("0", "ok");
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response delete(@PathVariable String id) {
		LOGGER.debug("id:  {}", id);
		«daoType.toFirstLower».delete(id);
		return new Response("0", "ok");
	}

	@InitBinder("«beanType.toFirstLower»")
	public void initBinder(DataBinder binder) {
		binder.setValidator(new «beanType»Validator());
	}
}
		'''
	}

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
	public boolean supports(Class<?> arg0) {
		return «beanType».class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		«FOR f : fields.filter[it.required.equals("required")].toList»
		ValidationUtils.rejectIfEmpty(arg1, "«f.name.toFirstLower»", null, "«f.description»不能为空！");
		«ENDFOR»
	}

}
	    '''
	}

	def static tableHtml(Project project, Record record, List<Field> fields) {
		var beanName = record.name
		'''
<div class="container inner-container">
	<div class="row"></div>
	<div class="row">
	  <table id="«beanName»-table" class="table table-striped table-bordered" cellspacing="0" width="100%">
	    <thead>
	        <tr>
		        «FOR f : fields»
		        <th>«f.chineseName»</th>
		        «ENDFOR»
	        </tr>
	    </thead>
	
	    <tfoot>
	        <tr>
				«FOR f : fields»
				<th>«f.name»</th>
				«ENDFOR»
	        </tr>
	    </tfoot>
	  </table>
	</div>
</div>
<script src="/js/«beanName».js"></script>
	    '''
	}

	def static js(Project project, Record record, List<Field> fields) {
		var beanName = record.name
		'''
$(document).ready(function() {
    $('#«beanName»-table').dataTable( {
        "ajax": "/«beanName»/",
        "columns": [
			«FOR f : fields SEPARATOR ","»
			{ "data": "«f.name»" }
			«ENDFOR»
        ]
    } );
} );
	    '''
	}

	def static controllerTxt(Project project, Record record, List<Field> fields) {
		var beanType = record.name.toFirstUpper
		var beanName = record.name
		var klassType = record.name.toFirstUpper + "Contoller"
		'''
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vc.xd.demo.common.DataResponse;

@Controller
@RequestMapping("/«beanName»")
public class «klassType» {

	@Autowired
	private «beanType»Repository «beanName»Repository;
	
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public DataResponse<List<«beanType»>> read() {
		List<«beanType»> «beanName»s = «beanName»Repository.findAll();
		return new DataResponse<List<«beanType»>>("0", "查询成功!", «beanName»s);
	}
	
	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String table() {
		return "«beanName»";
	}
}
	    '''
	}
	
	

}
