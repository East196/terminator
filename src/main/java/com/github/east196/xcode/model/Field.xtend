package com.github.east196.xcode.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString
import org.springframework.data.annotation.Id

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Field {
	@Id
	String id             				//ID
	String projectId				//项目ID
	String recordId
	String name					//名称
	String chineseName
	String dataType						//字段类型
	String description
//	String defaultValue
//	String minValue
//	String maxValue
	String required
	String keyType
	String sortIndex
	
	
	def getJavaType() {
		switch dataType{
			case "int":"Integer"
			default:"String"
		}
	}
	
}