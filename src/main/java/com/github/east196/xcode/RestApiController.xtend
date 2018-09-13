package com.github.east196.xcode

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/restapi")
class RestApiController {


	@RequestMapping("/bean")
	def bean(String info) {
		val map= Base.parse(info)
		val bean= RestApi.bean(map.project,map.record,map.fields)
		bean
	}
	
	@RequestMapping("/repo")
	def repo(String info) {
		val map= Base.parse(info)
		val repo= RestApi.repo(map.project,map.record,map.fields)
		repo
	}
	
}
