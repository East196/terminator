package com.github.east196.xcode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.east196.xcode.Base.Three;
import com.github.east196.xcode.model.GeneResult;

@RestController
public class GeneController {

	@RequestMapping(value = "/gene", method = RequestMethod.POST)
	public GeneResult gene(Three three,String type) {
		return Mysql2018.gene(three, type);
	}
}
