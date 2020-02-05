package com.github.east196.xcode.model;

import java.util.List;

import lombok.Data;

@Data
public class Three {
	Project project;
	Record record;
	List<Field> fields;
	
	
	public Three(){}
	
	public Three(Project project, Record record, List<Field> fields) {
		this.project=project;
		this.record=record;
		this.fields=fields;
	}
	
}