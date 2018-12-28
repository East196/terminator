package com.github.east196.xcode.meta

import com.github.east196.xcode.model.Three
import java.util.List

interface MetaParser {
	def List<Three> action(String info)
}