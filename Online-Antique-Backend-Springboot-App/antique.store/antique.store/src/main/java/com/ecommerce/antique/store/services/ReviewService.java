package com.ecommerce.antique.store.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.antique.store.entities.Review;
import com.ecommerce.antique.store.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	
	// To list all reviews
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	// get or retrieve the order object along with it's shipping order
	public Review getReviews(Long reviewid) {
		
		Optional<Review> opt = reviewRepository.findById(reviewid);

		if(opt.isPresent()){
			return opt.get();
		}
		return null;
	}

	// persist order object along with shipping order
	// this method will be called with POST request
	public Review addNewReview(Review review) {
		Review newReview = reviewRepository.save(review);
		return newReview;
	}
	
	
	// delete review records
	public boolean delete(long id) {
	    var removed = reviewRepository.removeIf(id);
	    if(removed > 0) {
	        return true;
	    }
	    else {
	        return false;
	    }
	}


}
