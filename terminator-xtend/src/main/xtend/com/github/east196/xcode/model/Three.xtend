package com.github.east196.xcode.model

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString
@Accessors
@EqualsHashCode
@ToString(singleLine=true)
class Three {
	package Project project
	package Record record
	package List<Field> fields

	new() {
	}

	new(Project project, Record record, List<Field> fields) {
		this.project = project
		this.record = record
		this.fields = fields
	}
}
