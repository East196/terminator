package com.github.east196.xcode.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString
import org.springframework.data.annotation.Id

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Record {
	@Id
	String id
	String projectId
	String name
	String chineseName
	String description
	String geneType
}