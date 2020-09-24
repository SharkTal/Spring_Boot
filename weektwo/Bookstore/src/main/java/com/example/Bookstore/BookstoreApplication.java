package com.example.Bookstore;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository catRepository) {
		return (args) ->{
			log.info("save categories");
			
			
			Category cat1 = new Category("IT");
			Category cat2 = new Category("Food");
			Category cat3 = new Category("Medical");
			Category cat4 = new Category("Math");
			
			catRepository.save(cat1);
			catRepository.save(cat2);
			catRepository.save(cat3);
			catRepository.save(cat4);
			
			Book book1 = new Book("Test1", "Julia", "2020", "00001", 89, cat1);
			brepository.save(book1);
			
			Book book2 = new Book("Test2", "Jussi", "2020", "00001", 79, cat2);
			brepository.save(book2);
			
			
			
		};
	}
		
}
