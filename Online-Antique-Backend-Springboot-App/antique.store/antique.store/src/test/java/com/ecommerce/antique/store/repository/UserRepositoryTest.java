package com.ecommerce.antique.store.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.User;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
//	@Test
//	public void testSaveUser() {
//		Address address=new Address();
//		address.setAddressid(11);
////		address.setAddressline1("vijay nagar");
////		address.setAddressline2("Kalyan");
////		address.setCity("navimumbai");
////		address.setCountry("India");
////		address.setPostcode("769889");
//		
//		User user=new User();
//		user.setUserid(1);
//		user.setUsername("janhavi");
//		user.setPasswd("janu2567");
//		user.setFirstname("Janhavi");
//		user.setLastname("Gadewar");
//		user.setContactno("9898980978");
//		user.setAdministrator(true);
//		user.setAddress(address);
//		
//		userRepository.save(user);
//		
//		
//	}

}
