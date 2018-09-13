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
		SpringApplication.run(Application, args)
	}
	

	@RequestMapping("/toRecord")
	def toRecord(String info) {
		return Base.parse(info);
	}

	@RequestMapping("/toBean")
	def toBean(String info) {
		val map= Base.parse(info)
		val bean= Base.bean(map.project,map.record,map.fields)
		bean
	}
	
}
