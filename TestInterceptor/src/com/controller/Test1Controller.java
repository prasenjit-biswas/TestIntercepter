package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test1")
public class Test1Controller {

	@RequestMapping("/hello/{name}")
	@ResponseBody
	public void sayHello(@PathVariable("name") String name){
		System.out.println(" Hello1 "+name);
	}
}
