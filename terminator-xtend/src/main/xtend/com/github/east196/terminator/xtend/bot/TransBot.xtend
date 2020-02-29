package com.github.east196.terminator.xtend.bot

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString
class People {
	/** 姓名 */
	String name
	// 性别
	String sex
}

@Accessors
@EqualsHashCode
@ToString
class Person {
	/** 姓名 */
	String name
	// 性别
	String sex
}

class TransGene {
	def static void main(String[] args) {
		var person = new Person
		person.name = "snow"
		person.sex = "girl"
//		person.className.println
//		person.cls.println
//		person.toPrettyJsonWithTypes.println
//		person.respondsTo("getName").println
//		person?.atIndex("name").println
//		person?.atIndex("abc.name").println
//		person?.call("getName").println
//		println(person?.name?.trim?: (person?.atIndex("name")))
//
//		var people = new People
//		people.name = person?.name ?: ""
//		people.println
//		BeanUtils.idx(people, "sex", person?.sex)
//		people.println
//		if (BeanUtils.getField(people, "abc") != null) {
//			BeanUtils.idx(people, "abc", person?.sex)
//		}
//		people.println

	}

	// TODO 目的是取代dozer，开发时可以使用反射，部署时可以用adaptor
	// 输入A.class，B.class，反射分析获得A2B.doc
	// ----手动补充A2B.doc
	// 通过A2B.doc生成 A2B.java，A2BAdaptors.java
	@Accessors
	@EqualsHashCode
	@ToString
	static class TransInfo {
		List<String> fromFields
		String toField
	}
}
