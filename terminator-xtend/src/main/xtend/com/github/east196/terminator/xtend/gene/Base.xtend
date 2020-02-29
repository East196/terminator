package com.github.east196.terminator.xtend.gene

import com.github.east196.terminator.xtend.bot.Bots
import com.github.east196.terminator.xtend.model.Field
import com.github.east196.terminator.xtend.model.Project
import com.github.east196.terminator.xtend.model.Record
import java.util.List

class Base {

	def static app(Project project) {
		val javaPath = project.root.split("\\.").join("\\")
		val basePackageName = project.root
		var content = '''
			package «basePackageName»;
			
			import org.springframework.boot.SpringApplication
			import org.springframework.boot.autoconfigure.SpringBootApplication
			
			@SpringBootApplication
			class Application {
				
				def static void main(String[] args) {
					SpringApplication.run(Application, args)
				}
				
			
			}
		'''
		var path = '''«project.path»\src\main\java\«javaPath»\Application.xtend'''
		Bots.copy(content, path)
	}

	def static bean(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
//		var packageName = record.name.toFirstLower
//		var beanName = record.name.toFirstLower
		'''
package «basePackageName»;

import java.util.List;
import java.util.Date;

import lombok.Data;

@Data
public class «klassType» {

	«FOR f : fields»
	/**«f.doc»**/
	private «f.javaType» «f.name.toFirstLower»;	
	«ENDFOR»

}
		'''
	}





}
