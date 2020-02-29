package com.github.east196.terminator.xtend.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Field {

	String id // ID
	String name // 名称
	String label
	String type // 字段类型
	String config
	String doc

	String length
	String required
	String keyType
	String show

	def getShowIn() {
		show
	}

	def getOrderIndex() {
		sortIndex
	}

	String projectId // 项目ID
	String recordId // 纪录ID
	// demo数据
	String defaultValue
	String fakerFunc

	// 开发平台
	String sortIndex
	String render
	String formGroup
	String formItem
	String formItemData

	String valid

	def String javaName() {
		name.replace(" ", "_").split("_").map[item|item.toFirstUpper].join().toFirstLower
	}

	def String javaType() {
		if (type.trim.isNullOrEmpty) {
			return "String"
		}
		switch (type.toFirstLower) {
			case "str":
				"String"
			case "string":
				"String"
			case "bool":
				"Boolean"
			case "boolean":
				"Boolean"
			case "datetime":
				"Date"
			case "date":
				"Date"
			case "int":
				"Integer"
			case "bigint":
				"long"
			case "long":
				"Long"
			case "double":
				"Double"
			case "list": '''List<«name.subSequence(0,name.length-1).toString.toFirstUpper»>'''
			case "array": '''List<«name.subSequence(0,name.length-1).toString.toFirstUpper»>'''
			case "object":
				name.toFirstUpper
			default:
				type.toFirstUpper
		}
	}

}
