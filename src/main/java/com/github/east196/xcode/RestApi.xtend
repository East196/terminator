package com.github.east196.xcode

import com.github.east196.xcode.bot.Bots
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import java.util.List

class RestApi { // bean repo feign
	
	def static gene(Project project, Record record, List<Field> fields) {

		val javaPath = project.root.split("\\.").join("\\")
		var packageName = record.name.toFirstLower

		var content = bean(project, record, fields)
		var path = '''«project.path»\src\main\xtend\«javaPath»\«packageName»\«record.name.toFirstUpper».xtend'''
		println(path)
		Bots.copy(content, path)

		content = dao(project, record, fields)
		path = '''«project.path»\src\main\xtend\«javaPath»\«packageName»\«record.name.toFirstUpper»Repository.xtend'''
		println(path)
		Bots.copy(content, path)
	}

	def static bean(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString
import org.springframework.data.annotation.Id


import java.util.List;
import java.util.Date;

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
public class «klassType» {

	«FOR f : fields»
	«IF f.key=="P"»@Id«ENDIF»
	«f.javaType» «f.name.toFirstLower»			//«f.doc»
	«ENDFOR»
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



}
