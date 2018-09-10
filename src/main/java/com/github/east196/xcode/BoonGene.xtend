package com.github.east196.xcode

import com.github.east196.xcode.bot.Bots
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.FieldRepository
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.ProjectRepository
import com.github.east196.xcode.model.Record
import com.github.east196.xcode.model.RecordRepository
import org.springframework.context.ApplicationContext
import org.springframework.context.ConfigurableApplicationContext

import static com.github.east196.xcode.Mongo.*

class BoonGene {

	def static init(ApplicationContext app) {
		val projectRepository = app.getBean(ProjectRepository)
		val recordRepository = app.getBean(RecordRepository)
		val fieldRepository = app.getBean(FieldRepository)
		val EnumTypeRepository = app.getBean(ProjectRepository)
		projectRepository.deleteAll
		recordRepository.deleteAll
		fieldRepository.deleteAll
		EnumTypeRepository.deleteAll
		val tables = Bots.tables("F:\\workspace\\dsl-new\\gene\\src\\main\\resources\\统一数据文档0727.doc")
		val projectTable = tables.get(0)
		val projectRow = projectTable.getRow(3)
		var project = new Project
		project.version = projectRow.getCell(0).text.trim
		project.name = projectRow.getCell(1).text.trim
		project.chineseName = projectRow.getCell(2).text.trim
		project.path = projectRow.getCell(3).text.trim
		project.root = projectRow.getCell(4).text.trim
		project.url = projectRow.getCell(5).text.trim
		project = projectRepository.save(project)
		println(project)

		for (var i = 1; i < tables.size; i++) {
			var table = tables.get(i)
			var record = new Record
			val recordRow = table.getRow(3)
			record.projectId = project.id
			record.geneType = recordRow.getCell(0).text.trim
			record.name = recordRow.getCell(1).text.trim
			record.chineseName = recordRow.getCell(2).text.trim
			record.description = recordRow.getCell(3).text.trim
			record = recordRepository.save(record)
			println(record)
			for (var rowIndex = 6; rowIndex < table.numRows; rowIndex++) {
				var fieldRow = table.getRow(rowIndex)
				var field = new Field
				field.projectId = project.id
				field.recordId = record.id
				field.dataType = fieldRow.getCell(0).text.trim
				field.name = fieldRow.getCell(1).text.trim
				field.chineseName = fieldRow.getCell(2).text.trim
				field.description = fieldRow.getCell(3).text.trim
				field.required = fieldRow.getCell(4).text.trim
				field.keyType = fieldRow.getCell(5).text.trim
				field.sortIndex = fieldRow.getCell(6).text.trim
				field = fieldRepository.save(field)
				println(field)
			}
		}
	}

	def static gene(ConfigurableApplicationContext app) {
		val projectRepository = app.getBean(ProjectRepository)
		projectRepository.findAll.forEach [ project |
			val javaPath = project.root.split("\\.").join("\\")
			val recordRepository = app.getBean(RecordRepository)
			recordRepository.findByProjectId(project.id).forEach [ record |
				var packageName = record.name.toFirstLower
				val fieldRepository = app.getBean(FieldRepository)
				val fields = fieldRepository.findByRecordId(record.id)

				var content = bean(project, record, fields)
				var path = '''«project.path»\src\main\xtend\«javaPath»\«packageName»\«record.name.toFirstUpper».java'''
				println(path)
				Bots.copy(content, path)

				content = dao(project, record,
					fields)
				path = '''«project.path»\src\main\xtend\«javaPath»\«packageName»\«record.name.toFirstUpper»Repository.java'''
				println(path)
				Bots.copy(content, path)

				content = controller(project, record,
					fields)
				path = '''«project.path»\src\main\xtend\«javaPath»\«packageName»\«record.name.toFirstUpper»Controller.java'''
				println(path)
				Bots.copy(content, path)

				content = validator(project, record,
					fields)
				path = '''«project.path»\src\main\xtend\«javaPath»\«packageName»\«record.name.toFirstUpper»Validator.java'''
				println(path)
				Bots.copy(content, path)

				content = tableHtml(project, record, fields)
				path = '''«project.path»\src\main\resources\templates\«record.name».html'''
				println(path)
				Bots.copy(content, path)

				content = js(project, record, fields)
				path = '''«project.path»\src\main\resources\static\js\«record.name».js'''
				println(path)
				Bots.copy(content, path)

				content = controllerTxt(project, record, fields)
				path = '''«project.path»\src\main\resources\static\tmp\«record.name».txt'''
				println(path)
				Bots.copy(content, path)
			]
		]
	}

}
