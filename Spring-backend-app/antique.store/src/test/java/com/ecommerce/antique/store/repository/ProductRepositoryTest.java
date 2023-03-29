package com.ecommerce.antique.store.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Category;
import com.ecommerce.antique.store.entities.Product;

//test basic CRUD operations
//It setup the environment with spring container and beans registered in it
@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void test() {
		assertTrue(true);
	}
	

	// get data from product table by Id
 @Test
 void findByIdMethod(){
     Long id = 1L;

     Product product = productRepository.findById(id).get();
 }

 // find data by name
 @Test
	public void findByProductname() {
		List<Product> products = productRepository.findByProductname("Antique Car");
		products.forEach(p->System.out.println(p.getProductdescription()));
	}
 
 // update data from product table
 @Test
	public void testCreateProduct() {
		// it insert the data into database
		Category category = new Category();
		
		category.setCategoryid(2);
		category.setCategoryname("Vase");
		category.setCategorydescription("This vase made in 1990.");
		category.setCategoryimage("vase.jpg");
		
		
		Product product = new Product();
		product.setProductid(3);
		product.setProductname("Vase1");
		product.setProductdescription("This vase made in 1990.");
		product.setProductimage("vase.jpg");
		product.setCategory(category);
		product.setDiscountpercent(12);
		product.setDiscountprice(90d);
		product.setPrice(new BigDecimal(100));
		
	
		//List<Product> products = new ArrayList<Product>();
		//products.add(category);
		
		
		productRepository.save(product); 	
		// create the insert query when we write the save method
		
	}
 
 // get all data from product table
 @Test
 void findAllMethod() {
 	//query -: select * from product;
 	List<Product> product = productRepository.findAll();
 	
 	product.forEach((p)->{
 		System.out.println(p.getProductname());
 		System.out.println(p.getProductid());
 		System.out.println(p.getProductdescription());
 	});
 }
 
 
 @Test
 void deleteMethod() {

 // find an entity by id
 Long productid = 15L;
 Product product = productRepository.getById(productid);

 // delete(entity)
 productRepository.delete(product);
 }
 
}

