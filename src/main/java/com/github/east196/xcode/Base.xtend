package com.github.east196.xcode

import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import com.github.east196.xcode.bot.Bots

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

	@Data
	static class Three {
		Project project
		Record record
		List<Field> fields
	}

	def static parse(String info) {
		val project = new Project
		val klass = info.split('/').get(0)
		val record = new Record
		record.name = klass
		val fields = info.split('/').get(1).split(' ').filter[!it.nullOrEmpty].map [ fieldInfo |
			val fieldInfos = fieldInfo.split(":")
			var field = new Field
			field.name = fieldInfos.get(0)
			if (fieldInfos.length == 2) {
				field.type = fieldInfos.get(1)
			} else {
				field.type = "string"
			}
			if (fieldInfos.length == 3) {
				field.label = fieldInfos.get(2)
			} else {
				field.label = ""
			}
			return field
		].toList
		new Three(project, record, fields)
	}

	def static init(String docx) {
		val tables = Bots.tables(docx)
		val projectTable = tables.get(0)
		val projectRow = projectTable.getRow(3)
		var project = new Project
		project.version = projectRow.getCell(0).text.trim
		project.name = projectRow.getCell(1).text.trim
		project.label = projectRow.getCell(2).text.trim
		project.path = projectRow.getCell(3).text.trim
		project.root = projectRow.getCell(4).text.trim
		project.port = projectRow.getCell(5).text.trim
		println(project)

		val threes = newArrayList()
		for (var i = 1; i < tables.size; i++) {
			var table = tables.get(i)
			var record = new Record
			val recordRow = table.getRow(3)
			record.projectId = project.id
			record.dbType = recordRow.getCell(0).text.trim
			record.name = recordRow.getCell(1).text.trim
			record.label = recordRow.getCell(2).text.trim
			record.doc = recordRow.getCell(3).text.trim
			println(record)
			val fields = newArrayList()
			for (var rowIndex = 6; rowIndex < table.numRows; rowIndex++) {
				var fieldRow = table.getRow(rowIndex)
				var field = new Field
				field.projectId = project.id
				field.recordId = record.id
				field.type = fieldRow.getCell(0).text.trim
				field.name = fieldRow.getCell(1).text.trim
				field.label = fieldRow.getCell(2).text.trim
				field.doc = fieldRow.getCell(3).text.trim
				field.required = fieldRow.getCell(4).text.trim
				field.keyType = fieldRow.getCell(5).text.trim
				field.sortIndex = fieldRow.getCell(6).text.trim
				println(field)
				fields.add(field)
			}
			val three = new Three(project, record, fields)
			threes.add(three)
		}
		threes
	}

}
