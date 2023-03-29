package com.ecommerce.antique.store.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.antique.store.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional <User> findByUserid(long userid);
	
}
