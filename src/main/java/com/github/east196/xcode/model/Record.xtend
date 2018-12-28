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
	String name
	String label
	String config
	String doc
	String projectId
	String dbType
	String dbName
	String tableName
	
	String geneOk
}