package com.github.east196.xcode.gene

import com.github.east196.xcode.bot.Bots
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
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

	def static String bean(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
		var packageName = record.name.toFirstLower
		'''
package «basePackageName».«packageName»;

import com.google.common.base.Objects;

«IF fields.exists[f|f.type.equals("repeated")]»
import java.util.List;
«ENDIF»
«IF fields.exists[f|f.type.equals("datetime")]»
import java.util.Date;
«ENDIF»

public class «klassType» {

	«FOR f : fields»
	/**«f.doc»**/
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





}
