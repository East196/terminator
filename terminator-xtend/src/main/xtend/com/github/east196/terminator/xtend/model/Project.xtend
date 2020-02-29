package com.github.east196.terminator.xtend.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Project {

	String id           //ID
	String name			//项目名称
	String label		//项目中文名称
	String path			//项目路径
	String root			//根包
	String language     //语言
	String port			//部署url
	String version		//版本标记	
	String config       //配置
	String doc          //详细描述
	
	
	String webPath
	String webRoot
	
	String androidPath
	String androidRoot
}
