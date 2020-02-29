package com.github.east196.terminator.xtend.meta

import com.github.east196.terminator.xtend.model.Field
import com.github.east196.terminator.xtend.model.Project
import com.github.east196.terminator.xtend.model.Record
import com.github.east196.terminator.xtend.model.Three

class StringMetaParser implements MetaParser{

	override action(String info) {
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
		#[new Three(project, record, fields)]
	}
	
}
