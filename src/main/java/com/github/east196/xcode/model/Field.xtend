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
	String name					//名称
	String label
	String type						//字段类型
	String config
	String doc
	
	String length
	String required
	String keyType
	
	String projectId				//项目ID
	String recordId					//纪录ID
	
	// demo数据
	String defaultValue
	String fakerFunc

	// 开发平台
	String sortIndex
	String render
	String formGroup 
	String formItem
	String formItemData
	
	def getJavaType() {
		switch type{
			case "int":"Integer"
			case "long":"Long"
			default:"String"
		}
	}
	
}