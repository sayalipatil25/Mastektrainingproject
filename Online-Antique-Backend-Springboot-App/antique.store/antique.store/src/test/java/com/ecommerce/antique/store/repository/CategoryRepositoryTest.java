package com.ecommerce.antique.store.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Category;

@SpringBootTest
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;
	
	// get data from category table by Id
 @Test
 void findByIdMethod(){
     Long id = 1L;

     Category category = categoryRepository.findById(id).get();
 }
 
 // get all data from category table
 @Test
 void findAllMethod() {
 	//query -: select * from category;
 	List<Category> category = categoryRepository.findAll();
 	
 	category.forEach((c)->{
 		System.out.println(c.getCategoryid());
 		System.out.println(c.getCategoryname());
 		System.out.println(c.getCategorydescription());
 	});
 }
 

}
