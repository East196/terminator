package com.github.east196.terminator.xtend.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Valid {//枚举类型

	///// 原始六大件

	String id             			//ID
	String name						//名称，就是field名称
	String label
	String type						//字段类型
	String config
	String doc
	
	// 验证参数，高表 name type value
	
	///// 字段三件套
	String projectId				//项目ID
	String recordId					//纪录ID
	String fieldId					//纪录ID
	//通过识别ID标识，无视数据库，直接查询
}
