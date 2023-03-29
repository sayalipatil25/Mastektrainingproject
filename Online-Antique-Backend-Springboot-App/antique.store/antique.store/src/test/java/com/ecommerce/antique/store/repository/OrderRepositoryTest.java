package com.ecommerce.antique.store.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.Order;
import com.ecommerce.antique.store.entities.Review;
import com.ecommerce.antique.store.entities.User;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired 
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	
	@Test
	public void testSaveOrderDetails() {
		
		Order order=new Order();
		order.setOrderid(1);
		//order.setOrdertrackingno("qukna");
		order.setOrderitemquantity(8);
		order.setTotalprice(5000);
		order.setUser(userRepository.findByUserid(6L).get());
		
		Address address=new Address();
		address.setAddressid(9);
		address.setAddressline1("mohali");
		address.setAddressline2("mehru");
		address.setCity("mogal");
		address.setCountry("Kazakistan");
		address.setPostcode("653879");
		order.setAddress(address);
		//order.setAddress(addressRepository.findById(7L).get());

		orderRepository.save(order);
		
	}
	
	@Test
    void getOrderMethod()
    {
        Order order = orderRepository.findById(7L).get();
        //System.out.println(order.getOrdertrackingno().toString());
        System.out.println(order.getAddress().getCity().toString());
    }
	
	
	@Test
    void updateOrderMethod(){
        Order order = orderRepository.findById(14L).get();
        order.setTotalprice(567);;
        order.getAddress().setPostcode("894999");
        orderRepository.save(order);
    }
	


	@Test
    void deleteOrderMethod(){
        orderRepository.deleteById(7L);
       
        
    }
	
	
	
}
