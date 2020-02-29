package com.github.east196.terminator.xtend.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class EnumType {//枚举类型

	String id             				//ID
	String projectId				//项目ID
	String name					//枚举类型名称
	String description			//描述
	String entrys					//实体列表
}
