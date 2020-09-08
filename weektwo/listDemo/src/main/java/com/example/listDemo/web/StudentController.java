package com.example.listDemo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.listDemo.domain.Student;



@Controller
public class StudentController {
	@GetMapping("/hello")
	public String GetList(Model model) {
		
		List<Student> ss = getList();
		model.addAttribute("Students", ss);
		return "sList";
	}
	
	private List<Student> getList(){
		List<Student> ss = new ArrayList<Student>();
		ss.add(new Student("Jack", "Ma"));
		ss.add(new Student("Seppo", "Lee"));
		ss.add(new Student("Pony", "Steele"));
		return ss;
	}
	
	
	
}
