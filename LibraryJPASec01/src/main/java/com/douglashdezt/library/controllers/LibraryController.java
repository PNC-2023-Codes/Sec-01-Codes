package com.douglashdezt.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglashdezt.library.models.dtos.MessageDTO;
import com.douglashdezt.library.models.entities.Book;
import com.douglashdezt.library.models.entities.Category;
import com.douglashdezt.library.services.BookService;
import com.douglashdezt.library.services.CategoryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/collection")
	public ResponseEntity<?> findAllBooks(){
		List<Book> books = bookService.findAll();
		return new ResponseEntity<>(
					books,
					HttpStatus.OK
				);
	}
	
	@GetMapping("/collection/{cat}")
	public ResponseEntity<?> findAllBooksByCategory(@PathVariable(name = "cat") String idCat){
		Category category = categoryService.findOneById(idCat);
		
		if (category == null) {
			return new ResponseEntity<>(
						new MessageDTO("Category not found!"),
						HttpStatus.NOT_FOUND
					);
		}
		
		List<Book> books = category.getBooks();
		
		return new ResponseEntity<>(
					books,
					HttpStatus.OK
				);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}








