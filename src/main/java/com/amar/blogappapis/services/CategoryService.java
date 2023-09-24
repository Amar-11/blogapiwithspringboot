package com.amar.blogappapis.services;

import java.util.List;

import com.amar.blogappapis.payloads.CategoryDto;

public interface CategoryService {

	//create
	public CategoryDto createCategory(CategoryDto categorydto);
	
	//update
	public CategoryDto updateCategory(CategoryDto categorydto, Integer categoryId);
	
	//delete
	public void deleteCategory(Integer categoryId);
	
	//get 
	public CategoryDto getCategory(Integer categoryId);
	
	//get all
	public List<CategoryDto> getCategories();


}

