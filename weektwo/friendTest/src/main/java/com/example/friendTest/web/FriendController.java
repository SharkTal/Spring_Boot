package com.example.friendTest.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.friendTest.domain.Friend;

@Controller
public class FriendController {
	
	List<Friend> friends = new ArrayList<Friend>();
	@GetMapping("/index")
	public String form(Model model) {
		
		Friend friend = new Friend();
		model.addAttribute("friend", friend);
		
		return "index";
	}
	
	@PostMapping("/index")
	public String friendSubmit(@ModelAttribute Friend friend, Model model) {
		friends.add(friend);
		model.addAttribute("Friends",friends);
		System.out.println(friends);
		return "index";
	}
}
