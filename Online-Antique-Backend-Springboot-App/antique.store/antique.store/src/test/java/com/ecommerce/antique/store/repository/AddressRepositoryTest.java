package com.ecommerce.antique.store.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.Order;

@SpringBootTest
public class AddressRepositoryTest {

	@Autowired
	AddressRepository addressRepository;
	
	
	@Test
	public void testSaveAddress() {
		Address address= new Address();
		address.setAddressid(1);
		address.setAddressline1("Mastek");
		address.setAddressline2("Andheri sypz");
		address.setCity("Mumbai");
		address.setCountry("India");
		address.setPostcode("457698");
		
		addressRepository.save(address);
		
	}
	
	@Test
    void getAddressMethod()
    {
		Address address= addressRepository.findById(3L).get();
        System.out.println(address.toString());
    }
	
	
	@Test
    void updateAddressMethod(){
		Address address= addressRepository.findById(3L).get();
		address.setPostcode("112233");
		addressRepository.save(address);
       
    }
	
	@Test
    void deleteAddressMethod(){
		Address address= addressRepository.findById(12L).get();
	
		addressRepository.delete(address);
    }
}
