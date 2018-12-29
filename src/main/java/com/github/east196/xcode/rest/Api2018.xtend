package com.github.east196.xcode.rest

import com.github.east196.xcode.bot.Bots

import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import com.github.east196.xcode.model.Three
import java.util.List
import org.apache.poi.hwpf.usermodel.Table
import org.eclipse.xtend.lib.annotations.Data

class Api2018 {
	val static projectPath = '''E:\workspace\github\east196\java\xcode'''
	val static basePackageName = "com.github.east196.demo"
	val static basePath = projectPath + '''/src/main/java/com/github/east196/demo'''
	var static src = '''E:\backup\xcode\统一接口文档20181228.doc'''

	def static table2data(Table table) {
		var Project project = new Project
		project.path = basePath
		project.root = basePackageName

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
				field.type = row.getCell(2).text.trim
				field.doc = row.getCell(3).text.trim
				fields.add(field)
			}

		}
		new Three(project, record, fields)
	}

	def static void main(String[] args) {
		val tables = Bots.tables(src)
		println("--表格总数：" + tables.size())

		val datatables = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("DATA")]
		val resttables = tables.filter[it.getRow(0).getCell(0).text.trim.equalsIgnoreCase("REST")]

		datatables.forEach [ table |
			val three = table2data(table)
			var Project project = three.project
			var Record record = three.record
			var List<Field> fields = three.fields
			var content = bean(project, record, fields)
			println(content)
		]

		resttables.forEach [ table |
			val rest = table2rest(table)
			var Three headers = rest.headers
			var Three params = rest.params
			var Three reqBody = rest.reqBody
			var Three respBody = rest.respBody

			println(threeContent(headers))
			println(threeContent(params))
			println(threeContent(reqBody))
			println(threeContent(respBody))
		]

	}
	
	protected def static CharSequence threeContent(Three three) {
		var Project project = three.project
		var Record record = three.record
		var List<Field> fields = three.fields
		if (fields.size ==0){
			return ''''''
		}
		var content = bean(project, record, fields)
		content
	}

	def static table2rest(Table table) {

		var Three headers = threeFrom(table, "Headers")
		var Three params = threeFrom(table, "Params")
		var Three reqBody = threeFrom(table, "ReqBody")
		var Three respBody = threeFrom(table, "RespBody")

		new HttpReqResp(headers, params, reqBody, respBody)
	}

	def static Three threeFrom(Table table, String type) {
		var Project project = new Project
		project.path = basePath + "/http"
		project.root = basePackageName + ".http"

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
			if (rowType.equalsIgnoreCase(type)&&!row.getCell(1).text.trim.nullOrEmpty) {
				var field = new Field()
				field.name = row.getCell(1).text.trim
				field.type = row.getCell(2).text.trim
				field.label = row.getCell(3).text.trim
				field.doc = row.getCell(3).text.trim
				fields.add(field)
			}
		}
		fields
	}
	
	
		def static bean(Project project, Record record, List<Field> fields) {
		val basePackageName = project.root
		var klassType = record.name.toFirstUpper
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

	@Data
	static class HttpReqResp {
		Three headers
		Three params
		Three reqBody
		Three respBody
	}

}
