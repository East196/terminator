package com.github.east196.terminator.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.east196.terminator.xtend.meta.DocMetaParser;
import com.github.east196.terminator.xtend.model.Three;
import com.github.east196.terminator.xtend.rest.AntDVue2018;
import com.github.east196.terminator.xtend.rest.Mysql2018;

@RestController
class Dev {

    @RequestMapping("/")
    String index() {
      return "Dev";
    }

    @RequestMapping("/json")
    List<Three> json(@RequestBody Args args) {
      return new DocMetaParser().action(args.file);
    }

    @RequestMapping("/bc")
    String backcode(@RequestBody Three three, String type) {
    	return Mysql2018.gene(three, type).getContent().toString();
    }
	
    @RequestMapping("/fc")
    String frontcode(@RequestBody Three three, String type) {
    	return AntDVue2018.gene(three, type).getContent().toString();
    }
}