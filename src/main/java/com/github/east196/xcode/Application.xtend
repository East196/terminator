package com.github.east196.xcode

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class Application {
	
	def static void main(String[] args) {
		SpringApplication.run(BoonGene, args)
	}
	

	@RequestMapping("/toRecord")
	def toRecord(@RequestBody String info) {
		return SimpleBeanParser.parse(info);
	}

	@RequestMapping("/toBean")
	def toBean(@RequestBody String info) {
		val map= SimpleBeanParser.parse(info)
		val bean= Base.bean(map.project,map.record,map.fields)
		bean
	}
	
}
