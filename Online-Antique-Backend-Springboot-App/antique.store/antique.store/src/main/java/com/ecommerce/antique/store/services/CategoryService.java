package com.ecommerce.antique.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.antique.store.entities.Category;
import com.ecommerce.antique.store.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	
	// Query -: select * from category
			// query to get all the products from database
			public List<Category> findAllCategory(){
				List<Category> category = categoryRepository.findAll();
				return category;
			}
	
	// get/ retrieve the order object along with it's shipping order
	public Category getOrderDetailsById(Long categoryid) {
		
		Optional<Category> category = categoryRepository.findById(categoryid);

		if(category.isPresent()){
			return category.get();
		}
		return null;
	}
}
