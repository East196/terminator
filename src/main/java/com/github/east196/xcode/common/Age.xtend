package com.github.east196.xcode.common

import org.eclipse.xtend.lib.annotations.Data
import java.time.LocalDate
import java.time.Period

@Data
class Age {
	
	int year
	int month
	int day

	def getAge() {
		val today = LocalDate.now();
		val birthday = LocalDate.of(year, month, day);
		var period = Period.between(birthday, today);
		return period.years
	}
}