package com.github.east196.xcode.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.github.east196.xcode.meta.StringMetaParser
import com.github.east196.xcode.gene.RestApi

@RestController
@RequestMapping("/restapi")
class RestApiController {


	@RequestMapping("/bean")
	def bean(String info) {
		val map= new StringMetaParser().action(info).get(0)
		val bean= RestApi.bean(map.project,map.record,map.fields)
		bean
	}
	
	@RequestMapping("/repo")
	def repo(String info) {
		val map= new StringMetaParser().action(info).get(0)
		val repo= RestApi.repo(map.project,map.record,map.fields)
		repo
	}
	
}
