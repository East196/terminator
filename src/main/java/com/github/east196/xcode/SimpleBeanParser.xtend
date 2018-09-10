package com.github.east196.xcode

import com.github.east196.xcode.common.Easy
import com.github.east196.xcode.model.Field
import com.github.east196.xcode.model.Project
import com.github.east196.xcode.model.Record
import java.util.List
import org.eclipse.xtend.lib.annotations.Data

class SimpleBeanParser {
	def static void main(String[] args) {
		println("8dcebf9e179c9f3a58ce173e04b9290b375a73f0dfec80bab5450d25f03f4c3bfd3eb44cd8e8aa874208bdbf963ac5a1".length)
		println(Easy.md5("MjM5Njc4MDIzNw=="))
	}
	
	@Data
	static class Three{
		Project project
		Record record
		List<Field> fields
	}
	
	def static parse(String info){
		val project=new Project
		val klass=info.split('/').get(0)
		val record=new Record
		record.name=klass
		val fields=info.split('/').get(1).split(' ').filter[!it.nullOrEmpty].map[fieldInfo|
			val fieldInfos=fieldInfo.split(":")
			var field=new Field
			if(fieldInfos.length==2){
				field.dataType=fieldInfos.get(1)
			}else{
				field.dataType="string"
			}
			field.name=fieldInfos.get(0)
			return field
		].toList
		new Three(project,record,fields)
	}
	
}