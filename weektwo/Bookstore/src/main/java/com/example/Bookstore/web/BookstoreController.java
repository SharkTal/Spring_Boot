package com.example.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Bookstore.domain.Book;

@Controller
public class BookstoreController {
	
	List<Book> books = new ArrayList<Book>();
	@GetMapping("/index")
	public String bookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		
		return "bookForm";
	}
	
	@PostMapping("/index")
	public String bookSubmit(@ModelAttribute Book book, Model model) {
		books.add(book);
		model.addAttribute("Books", books);
		System.out.println(books);
		
		return "bookstore";
	}
}
