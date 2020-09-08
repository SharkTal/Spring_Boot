package com.example.friends.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.friends.domain.Friend;

@Controller
public class FriendController {
	
	private List<Friend> fs = new ArrayList<Friend>();
	
	@GetMapping("/index")
	public String fForm(Model model) {
		Friend friend = new Friend();
		model.addAttribute("friend", friend);
		return "index";
	}
	
	
	
	@PostMapping("/index")
	public String fSubmit(@ModelAttribute Friend friend, Model model) {
		fs.add(friend);
		model.addAttribute("Friends", fs);
		System.out.println(fs);
		return "index";
	}
}
