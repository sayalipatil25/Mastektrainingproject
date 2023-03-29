package com.ecommerce.antique.store.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.antique.store.entities.IdReq;
import com.ecommerce.antique.store.entities.Review;
import com.ecommerce.antique.store.services.ReviewService;
import com.fasterxml.jackson.annotation.JsonProperty;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	// to fetch all reviews from database
	// URL -: http://localhost:8080/api/v3/reviews/1
	@GetMapping("/reviews/{id}")
	public ResponseEntity<Review> getOrderById(@PathVariable("id") long id) {
		
		Review review = reviewService.getReviews(id);
		if(review != null) {
			return new ResponseEntity<Review>(review, HttpStatus.OK);		
		}
		else
			// throw new ResponseNotFoundException("Order id is not found");
			return new ResponseEntity<Review>(HttpStatus.NO_CONTENT); // NO_CONTENT - Http Status code 204 
	}
	
	//http://localhost:8080/api/v3/reviews/add
	// add review into db
	@PostMapping("/reviews/add")
	public ResponseEntity<Review> addNewReview(@RequestBody Review review) {
		Review savedReview = reviewService.addNewReview(review);
		return new ResponseEntity<Review>(savedReview, HttpStatus.CREATED);
	}
	
	
	// http://localhost:8080/api/v3/delete/26
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Review> deleteReviewById(@PathVariable("id") long id) {
		//reviewService.deleteReview(id);
		 boolean complete = reviewService.delete(id);
		   if(complete) {
		return new ResponseEntity<Review>(HttpStatus.OK);
	}
    else {
	      return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
	   }
	}

}
