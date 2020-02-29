package com.github.east196.terminator.xtend.model

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Record {

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
	
	// http
	String method
	String url
	String action
	String dataType // body - data - object|list
	String dataName
	
}
