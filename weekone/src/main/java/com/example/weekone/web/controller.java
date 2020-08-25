package com.example.weekone.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class controller {
	@RequestMapping("/index")
	public String index() {
		return "This is the main page";
	}
	
	@RequestMapping("/hello")
	public String hello(@RequestParam(name="location",required=false,defaultValue="earth") String location, @RequestParam(name="name",required=false, defaultValue="Alien") String name) {
		return "Welcome to the "+ location +", " + name;
	}
}
