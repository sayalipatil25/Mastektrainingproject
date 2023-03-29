package com.ecommerce.antique.store.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.ecommerce.antique.store.entities.Product;

@SpringBootTest
public class PagingSortingTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testPagination() {
		int pageNo = 0;
		int pageSize = 3;
		
		// create pageable object
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		Page<Product> page = productRepository.findAll(pageable);
		
		List<Product> list = page.getContent();
		for(Product product : list) {
			System.out.println(product);
			
		}
		
	}
}
