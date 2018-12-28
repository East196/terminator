package com.github.east196.xcode.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.east196.xcode.model.Three;
import com.github.east196.xcode.model.GeneResult;

@RestController
public class GeneController {

	@RequestMapping(value = "/gene", method = RequestMethod.POST)
	public GeneResult gene(Three three,String type) {
		return Mysql2018.gene(three, type);
	}
	
	@RequestMapping(value = "/geneweb", method = RequestMethod.POST)
	public GeneResult geneweb(Three three,String type) {
		return AntDVue2018.gene(three, type);
	}
}
