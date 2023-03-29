package com.ecommerce.antique.store.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecommerce.antique.store.entities.Category;
import com.ecommerce.antique.store.entities.Product;
import com.ecommerce.antique.store.repository.CategoryRepository;
import com.ecommerce.antique.store.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	ProductRepository productRepository;
	CategoryRepository categoryRepository;
	
	// pagination 
	public List<Product> getProductBasedOnPage(int pageNumber, int pageSize){
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Product> page = productRepository.findAll(pageable);
		List<Product> product = page.getContent();
		if(product.isEmpty()) {
		int oldPageNumber = pageNumber -1;
		pageable = PageRequest.of(oldPageNumber, pageSize);
		page = productRepository.findAll(pageable);
		product = page.getContent();
		
			}
			return product;
		}
	
	// fetch products by ID
	// get/ retrieve the product object 
	public Product getProductDetailsById(Long productid) {
		
		Optional<Product> opt = productRepository.findById(productid);

		if(opt.isPresent()){
			return opt.get();
		}
		return null;
	}
	
	public Category getCategoryDetailsById(Long categoryid) {
		
		Optional<Category> opt = categoryRepository.findById(categoryid);

		if(opt.isPresent()){
			return opt.get();
		}
		return null;
	}
	
	public List<Product> getProductByCategory(long id) {
		List<Product> product = productRepository.findByCategoryCategoryid(id);
		return product;
	}
	
	// Query -: select * from products
	// query to get all the products from database
	public List<Product> findAllProducts(){
		List<Product> productList = productRepository.findAll();
		return productList;
	}
	
	// filter the products
	public List<Product> findByPriceGreaterThan(BigDecimal price, Sort sort){
		List<Product> productListByPrice = productRepository.findAll(sort);
		return productListByPrice;
	}
	
//	public Product newProduct(Product product) {
//		Product newProduct = productRepository.save(product);
//		return newProduct;
//	}
	
	// Search book by title
//	public List<Product> findByProductnameContaining(String key){
//		
//		List<Product> searchedProduct = productRepository.findAll();
//		return searchedProduct;
//					
//	}
	
	// sorting products
	public List<Product> findProductWithSorting(String field){
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
		
	}
	
}
