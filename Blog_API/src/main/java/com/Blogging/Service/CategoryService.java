package com.Blogging.Service;

import java.util.List;

import com.Blogging.Entities.Category;
import com.Blogging.Exceptions.CategoryNotFound;

public interface CategoryService {
	
	public Category create(Category category);
	
	public Category update(Category category,Integer categoryId)throws CategoryNotFound;

	
	public Category Delete(Integer categoryId) throws CategoryNotFound;
	
	public List<Category> getAllCatrgories();
	
	public Category getById(Integer categoryId) throws CategoryNotFound;
	
}
