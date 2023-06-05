package com.douglashdezt.library.controllers;

import java.util.List;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglashdezt.library.models.dtos.MessageDTO;
import com.douglashdezt.library.models.dtos.SaveCategoryDTO;
import com.douglashdezt.library.models.entities.Category;
import com.douglashdezt.library.services.CategoryService;
import com.douglashdezt.library.utils.RequestErrorHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private RequestErrorHandler errorHandler;
	
	@GetMapping("/all")
	public ResponseEntity<?> findAllCategories(){
		List<Category> categories = categoryService.findAll();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findOneCategory(@PathVariable(name = "id") String code) {
		Category category = categoryService.findOneById(code);
		
		if(category == null) {
			return new ResponseEntity<>(
					new MessageDTO("Category not found"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> saveCategory(@ModelAttribute @Valid SaveCategoryDTO info, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(
					errorHandler.mapErrors(validations.getFieldErrors()), 
					HttpStatus.BAD_REQUEST);
		}
		
		try {
			categoryService.save(info);
			return new ResponseEntity<>(
					new MessageDTO("Category created"), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(
					new MessageDTO("Internal Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
