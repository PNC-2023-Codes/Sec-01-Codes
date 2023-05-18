package com.douglashdezt.library.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.douglashdezt.library.models.entities.Category;

public interface CategoryRepository 
	extends ListCrudRepository<Category, String>{
	
}
