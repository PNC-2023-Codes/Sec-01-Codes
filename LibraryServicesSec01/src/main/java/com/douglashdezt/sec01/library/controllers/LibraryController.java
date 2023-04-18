package com.douglashdezt.sec01.library.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.douglashdezt.sec01.library.models.dtos.SaveBookDTO;
import com.douglashdezt.sec01.library.models.entities.Book;
import com.douglashdezt.sec01.library.services.BookService;
import com.douglashdezt.sec01.library.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/library")
public class LibraryController {
    
	@Autowired
	private BookService bookService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getBookList(Model model) {
    	model.addAttribute("books", bookService.findAll());
    	return "book-list";
    }
    
    @GetMapping("/")
    public String getMainpage(Model model) {
    	String time = Calendar.getInstance().getTime().toString();
    	model.addAttribute("time", time);
    	
    	return "main";
    }
    
    @PostMapping("/save")
    public String saveBook(@ModelAttribute @Valid SaveBookDTO bookInfo,
    		BindingResult validations, Model model) {
    	
    	if(validations.hasErrors()) {
    		System.out.println("Hay errores");
    		
    		model.addAllAttributes(
    				errorHandler.mapErrors(validations.getFieldErrors())
    			);
    		
    		model.addAttribute("hasErrors", true);
    		
    		return "main";
    	}
    	
    	System.out.println(bookInfo);
    	
    	Book newBook = new Book(bookInfo.getIsbn(), bookInfo.getTitle());
    	bookService.save(newBook);
    	
    	return "redirect:/library/all";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

}
