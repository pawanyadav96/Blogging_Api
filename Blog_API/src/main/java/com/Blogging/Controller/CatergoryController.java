package com.Blogging.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Entities.Category;
import com.Blogging.Exceptions.CategoryNotFound;
import com.Blogging.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CatergoryController  {
	
	
	@Autowired
	public CategoryService cservice;
	
	@PostMapping("/create")
	public ResponseEntity<Category> createCategoryHandler(@Valid @RequestBody Category category) 
	{
		Category cat=cservice.create(category);
		
		return new ResponseEntity<Category>(cat,HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<Category> updatecategoryhandler( @Valid @RequestBody Category cat,@PathVariable Integer catId ) throws CategoryNotFound
	{
		Category category=cservice.update(cat, catId);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<Category> getByidhandler(@PathVariable Integer catId)throws CategoryNotFound
	{
		Category category=cservice.getById(catId);
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<Category>> getAllhandler()
	{
		List<Category> category=cservice.getAllCatrgories();
		return new ResponseEntity<List<Category>>(category,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Category> deletehandler(@PathVariable Integer id)throws CategoryNotFound
	{
		Category cat=cservice.Delete(id);
		return new ResponseEntity<>(cat,HttpStatus.OK);
		
	}
	
}
