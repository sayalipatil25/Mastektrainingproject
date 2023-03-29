package com.ecommerce.antique.store.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.antique.store.entities.APIResponse;
import com.ecommerce.antique.store.entities.Product;
import com.ecommerce.antique.store.repository.ProductRepository;
import com.ecommerce.antique.store.services.ProductServices;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v2")
public class ProductController {

	private ProductServices productService;
	//private CategoryService categoryService;
	
	@Autowired
	ProductRepository productRepository;
	
	public ProductController(@Autowired ProductServices service) {
		this.productService = service;
	}
	
	// pagination
	// this URL will read data from query parameters
	// query parameter are appended at the end of URL after
	// http://localhost:8080/page/products?pgnum=0&size=2
	@GetMapping(value = "/page/products", produces = "application/json")
	public List<Product> getProductsOnPage(@RequestParam("pgnum") int pageNumber, @RequestParam("size") int pageSize) {
		List<Product> product = this.productService.getProductBasedOnPage(pageNumber, pageSize);
		return product;
	}
	
	
	// filter data
	@GetMapping(value = "/filter/products", produces = "application/json")
	public ResponseEntity<List<Product>> findByPriceGreaterThan(@RequestParam BigDecimal price, Product product ){
		return new ResponseEntity<List<Product>>(productRepository.findAllProductByPrice(price), HttpStatus.OK);
	}
	
	//	public ResponseEntity<List<Product>> findByPriceGreaterThan(@RequestParam("price") BigDecimal price, Sort sort) {
	//		return new ResponseEntity<List<Product>>(productService.findByPriceGreaterThan(price, sort), HttpStatus.OK); 
	//	}
			
		// search data 
		 @GetMapping(value = "/search", produces = "application/json")
		 public ResponseEntity<List<Product>> getBooksByTitleLikeIgnoreCase(@RequestParam("key") String key) {
			 return new ResponseEntity<List<Product>>(productRepository.findAllProductByName("%"+key+"%"), HttpStatus.OK);
		 }

		// to fetch all products data by ID
		@GetMapping("/products/{id}")
		public ResponseEntity<Product> getOrderById(@PathVariable("id") long id) {
			
			Product product = productService.getProductDetailsById(id);
			if(product != null) {
				return new ResponseEntity<Product>(product, HttpStatus.OK);		
			}
			else
				// throw new ResponseNotFoundException("Order id is not found");
				return new ResponseEntity<Product>(HttpStatus.NO_CONTENT); // NO_CONTENT - Http Status code 204 
		}
		
//		// to fetch all category data by ID
		@GetMapping("/category/{id}")
		public ResponseEntity<List<Product>> getProductByCategory(@PathVariable("id") Long id) {

			return new ResponseEntity<List<Product>>(productService.getProductByCategory(id), HttpStatus.OK);
		}
		
		
	// to fetch all product data
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAllProducts(){
		List<Product> product = productService.findAllProducts();
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

//		@PostMapping("/products")
//		public ResponseEntity<Product> addNewProduct(@RequestBody Product product)
//		{
//		Product savedProduct = productService.newProduct(product);
//		return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED); // CREATED - Http status code - 201
//		}
		
	// sorting by fields in products
		@GetMapping("/sorting/{field}")
		private APIResponse<List<Product>> getProductWithSort(@PathVariable String field){
			List<Product> allProducts = productService.findProductWithSorting(field);
			return new APIResponse<>(allProducts.size(), allProducts);
			
		}
}
