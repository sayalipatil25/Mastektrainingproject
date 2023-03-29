package com.ecommerce.antique.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.antique.store.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	// get product by ID
	Optional<Category> findByCategoryid(long categoryid);

	// searching of product by name and description
//	@Query("SELECT c FROM Category c WHERE c.categoryname LIKE %?1%"
//			+ "OR c.categorydescription LIKE %?1%")
//	public List<Category> findAllCategoryByName(String keyword);
//			
}
