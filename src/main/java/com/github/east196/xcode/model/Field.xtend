package com.github.east196.xcode.model

import com.google.common.base.CaseFormat
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

	def String javaName() {
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, name.toLowerCase())
	}

	def String javaType() {
		switch (type.toFirstLower) {
			case "bool": "Boolean"
			case "boolean": "Boolean"
			case "varchar": "String"
			case "datetime": "Date"
			case "date": "Date"
			case "int": "Integer"
			case "bigint": "long"
			case "long": "Long"
			case "double": "Double"
			case "array" : name.subSequence(0,name.length-1).toString.toFirstUpper
			case "object" : name.toFirstUpper
			default: type.toFirstUpper
		}
	}

}
