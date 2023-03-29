package com.ecommerce.antique.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.antique.store.entities.Category;
import com.ecommerce.antique.store.services.CategoryService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class CategoryController {

private CategoryService categoryService;
	
	public CategoryController(@Autowired CategoryService service) {
		this.categoryService = service;
	}
	
	// to fetch all product data
		@GetMapping("/category")
		public ResponseEntity<List<Category>> findAllProducts(){
			List<Category> category = categoryService.findAllCategory();
			return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
		}
	
	// to fetch all category data by ID
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getOrderById(@PathVariable("id") long id) {
		
		Category category = categoryService.getOrderDetailsById(id);
		if(category != null) {
			return new ResponseEntity<Category>(category, HttpStatus.OK);		
		}
		else
			// throw new ResponseNotFoundException("Order id is not found");
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT); // NO_CONTENT - Http Status code 204 
	}
}
