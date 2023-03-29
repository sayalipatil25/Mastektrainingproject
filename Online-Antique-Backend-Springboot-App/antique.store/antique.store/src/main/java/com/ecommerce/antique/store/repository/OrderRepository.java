package com.ecommerce.antique.store.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.antique.store.entities.Order;

import com.ecommerce.antique.store.entities.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional <Order> findByOrderid(long orderid);
//	
//	// delete products
		@Transactional
		@Modifying
		@Query("DELETE FROM orders WHERE orderid = ?1")
		int removeIf(@Param("id") long id);
}
