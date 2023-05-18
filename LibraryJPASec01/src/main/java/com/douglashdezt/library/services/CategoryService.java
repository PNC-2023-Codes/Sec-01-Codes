package com.douglashdezt.library.services;

import java.util.List;

import com.douglashdezt.library.models.dtos.SaveCategoryDTO;
import com.douglashdezt.library.models.entities.Category;

public interface CategoryService {
	public void save(SaveCategoryDTO info) throws Exception;
	public void deleteById(String code) throws Exception;
	public List<Category> findAll();
	public Category findOneById(String code);
}
