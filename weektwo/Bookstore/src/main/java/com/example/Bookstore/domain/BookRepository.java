package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface BookRepository extends CrudRepository <Book, Long>{
	//get books by title
	List<Book> findByTitle(@Param("title") String title);
	
	//get books by year
	List<Book> findByYear(@Param("year") String year);
	
	//get books by author
	List<Book> findByAuthor(@Param("author") String author);
}
