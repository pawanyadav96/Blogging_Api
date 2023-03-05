package com.Blogging.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blogging.Entities.Category;
import com.Blogging.Exceptions.CategoryNotFound;
import com.Blogging.Repository.CategoryRepo;
import com.Blogging.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	public CategoryRepo crepo;
	
	
	@Override
	public Category create(Category category) {
		  Category ct=crepo.save(category);
		  return ct;
	}

	@Override
	public Category update(Category category, Integer categoryId) throws CategoryNotFound {
		Optional<Category> cat=crepo.findById(categoryId);
		if(cat.isPresent())
		{
			Category updatedcat=cat.get();
			updatedcat.setCategoryTitle(category.getCategoryTitle());
			updatedcat.setCategoryDescripton(category.getCategoryDescripton());
			crepo.save(updatedcat);
			return updatedcat;
			
		
		}
		else
		{
			throw new CategoryNotFound("No field found with this id");
		}
	}

	@Override
	public Category Delete(Integer categoryId) throws CategoryNotFound {
		Optional<Category> cat=crepo.findById(categoryId);
		if(cat.isPresent())
		{
			Category deletedcat=cat.get();
			crepo.delete(deletedcat);
			return deletedcat;
		}
		else
		{
			throw new CategoryNotFound("No field found with this id");
		}
		
	}

	@Override
	public List<Category> getAllCatrgories() {
	List<Category> cat =crepo.findAll();
		return cat;
	}

	@Override
	public Category getById(Integer categoryId) throws CategoryNotFound {
		Optional<Category> cat=crepo.findById(categoryId);
		if(cat.isPresent())
		{
			Category catry=cat.get();
			return catry;
		}
		else
		{
			throw new CategoryNotFound("No field found with this id");
		}
		
	}

}
