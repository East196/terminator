package com.github.east196.xcode.meta

import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import com.github.east196.xcode.model.Three
import java.io.FileInputStream
import org.apache.poi.hwpf.HWPFDocument
import org.apache.poi.hwpf.usermodel.TableIterator

class DocMetaParser implements MetaParser {

	override action(String docx) {
		val tables = tables(docx)
		val projectTable = tables.get(0)
		
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

		println(project)

		val threes = newArrayList()
		for (var i = 1; i < tables.size; i++) {
			var table = tables.get(i)
			var record = new Record
			val recordOkRow = table.getRow(0)
			record.geneOk = recordOkRow.getCell(1).text.trim			
			
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
				print(fieldRow)
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
				field.show = fieldRow.getCell(7).text.trim
				println(field)
				fields.add(field)
			}
			val three = new Three(project, record, fields)
			threes.add(three)
		}
		threes
	}

	static def doc(String path) {
		var is = new FileInputStream(path)
		new HWPFDocument(is)
	}

	static def tables(String path) {
		var range = path.doc.range
		val tables = newArrayList()
		var tableIterator = new TableIterator(range)
		while (tableIterator.hasNext) {
			var table = tableIterator.next()
			tables.add(table)
		}
		tables
	}

}
