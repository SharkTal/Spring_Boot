package com.example.getAge.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgeController {
	@GetMapping("/hello")
	public String checkAge(@RequestParam(value="name")String name, @RequestParam(value="age") int age, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("age",age);
		return "greeting";
	}
}
