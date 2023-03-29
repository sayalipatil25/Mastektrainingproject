package com.ecommerce.antique.store.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.antique.store.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByReviewid(Long reviewid);

	// delete products
	@Transactional
	@Modifying
	@Query("DELETE FROM review WHERE reviewid = ?1")
	int removeIf(@Param("id") long id);
		
}
