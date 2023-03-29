package com.ecommerce.antique.store.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.antique.store.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	// custom queries will be added
			// query by JPA : select * from Product where name = ?1(positional parameter);
			List<Product> findByProductname(String productiname);
		
			// get product by ID
			Optional<Product> findByProductid(long productid);
			
			List<Product> findByCategoryCategoryid(long id);
			
			// searching of product by name and description
			@Query("SELECT p FROM Product p WHERE p.productname LIKE %?1%"
					+ " OR p.productdescription LIKE %?1%")
			public List<Product> findAllProductByName(String keyword);
			
			// filter by price greater than
			//@Query("SELECT p FROM Product p WHERE ")
			//List<Product> findByPriceGreaterThan(BigDecimal price, Sort sort);
			
			// filter by price less than 
			List<Product> findByPriceLessThan(BigDecimal price);

			List<Product> findAllProductByPrice(BigDecimal price);
			
		
}
