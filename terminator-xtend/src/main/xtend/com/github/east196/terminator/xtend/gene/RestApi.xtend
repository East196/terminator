package com.github.east196.terminator.xtend.gene

import com.github.east196.terminator.xtend.bot.Bots
import com.github.east196.terminator.xtend.meta.DocMetaParser
import com.github.east196.terminator.xtend.model.Field
import com.github.east196.terminator.xtend.model.Project
import com.github.east196.terminator.xtend.model.Record
import java.util.List

class RestApi { // bean repo feign

	def static void main(String[] args) {
		new DocMetaParser().action('''E:\backup\xcode\统一数据文档20180913.doc''').forEach[three|
			gene(three.project,three.record,three.fields)
			Base.app(three.project)
		]
	}
	
	def static gene(Project project, Record record, List<Field> fields) {

		val javaPath = project.root.split("\\.").join("\\")
		var packageName = record.name.toFirstLower

		var content = bean(project, record, fields)
		var path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper».xtend'''
		println(path)
		Bots.copy(content, path)

		content = repo(project, record, fields)
		path = '''«project.path»\src\main\java\«javaPath»\«packageName»\«record.name.toFirstUpper»Repository.xtend'''
		println(path)
		Bots.copy(content, path)
	}

	def static bean(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
		var packageName = record.name.toFirstLower
		'''
package «IF !basePackageName.nullOrEmpty»«basePackageName».«ENDIF»«packageName»;

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

import java.util.List;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty


@Accessors
@EqualsHashCode
@ToString(singleLine=true)
@Entity
public class «klassType» {

	«FOR f : fields»
	«IF f.getKeyType=="P"»@Id @GeneratedValue(strategy = GenerationType.IDENTITY)«ENDIF»
	«IF f.required=="required"»@NotEmpty«ENDIF»
	«f.javaType» «f.name.toFirstLower»			//«f.label»
	
	«ENDFOR»
}
		'''
	}

	def static repo(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var beanType = record.name.toFirstUpper
		var klassType = record.name.toFirstUpper + "Repository"
		var packageName = record.name.toFirstLower
		'''
package «IF !basePackageName.nullOrEmpty»«basePackageName».«ENDIF»«packageName»;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface «klassType» extends JpaRepository<«beanType», Long>, JpaSpecificationExecutor<«beanType»> {
	// add more ...
}
		'''
	}



}
