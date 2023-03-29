package com.ecommerce.antique.store.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Product;
import com.ecommerce.antique.store.entities.Review;
import com.ecommerce.antique.store.entities.User;

@SpringBootTest
public class ReviewRepositoryTest {
	@Autowired
	ReviewRepository reviewRepository;
	
	@Test
	public void test() {
		assertTrue(true);
	}
	

	// get data from product table by Id
	 @Test
	 void findByIdMethod(){
	     Long id = 1L;
	
	     Review review = reviewRepository.findById(id).get();
	 }

	 // insert data from review table
	@Test
	public void testCreateReview() {
		// it insert the data into database
	 	Product product = new Product();
	 	product.setProductid(3);
	 	
	 	User user = new User();
	 	user.setUserid(1);
	 	
	 	Review review = new Review();
	 	review.setRating(6);
	 	review.setReviewtext("This is good product but not happy with service.");
	 	review.setProduct(product);
	 	review.setUser(user);
		
		//List<Product> products = new ArrayList<Product>();
		//products.add(category);
		
		
		reviewRepository.save(review); 	
		// create the insert query when we write the save method		
	}
	
	 // get all data from product table
	 @Test
	 void findAllMethod() {
	 	//query -: select * from product;
	 	List<Review> review = reviewRepository.findAll();
	 	
	 	review.forEach((r)->{
	 		System.out.println(r.getRating());
	 		System.out.println(r.getReviewtext());
	 	});
	 }
 
	 // update rating method
	 @Test
	 void updateRatingMethod(){
	     Review review = reviewRepository.findById(26L).get();
	     review.setRating(8);
	     review.setReviewtext("service is not good");
	     reviewRepository.save(review);
	 }
	 
 
	 // delete review by Id
	 @Test
	 void deleteMethod() {

	 // find an entity by id
	 Long id = 26L;
	 Review review = reviewRepository.getById(id);

	 // delete(entity)
	 reviewRepository.delete(review);
	 }
	 
}
