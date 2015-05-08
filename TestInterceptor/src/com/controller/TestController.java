package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/hello/{name}")
	@ResponseBody
	public void sayHello(@PathVariable("name") String name){
		System.out.println(" Hello "+name);
	}
	
	@RequestMapping("/hello/{eaid}/{erid}")
	@ResponseBody
	public void sayHello1(@PathVariable("eaid") String eaid, @PathVariable("erid") String erid){
		System.out.println(" Hello "+eaid+" , "+erid);
	}
}
