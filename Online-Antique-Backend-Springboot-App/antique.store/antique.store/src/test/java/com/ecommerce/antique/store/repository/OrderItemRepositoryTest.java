package com.ecommerce.antique.store.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.Order;
import com.ecommerce.antique.store.entities.OrderItem;
import com.ecommerce.antique.store.entities.Product;



@SpringBootTest
public class OrderItemRepositoryTest {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Test
	public void testSaveOrderItems() {
		
		Order order=new Order();
		
		order.setUser(userRepository.findByUserid(6L).get());
		order.setTotalprice(688);
		
//		Product product= new Product();
//		product.setProductid(3);
		
		OrderItem item1 = new OrderItem();
		
		item1.setProduct(productRepository.findById(4L).get());
		item1.setQuantity(9);
		item1.setOrder(order);
		
		OrderItem item2 = new OrderItem();
		
		item2.setProduct(productRepository.findById(2L).get());
		item2.setQuantity(2);
		item2.setOrder(order);
		
		//set item using order object
        List<OrderItem> list = new ArrayList<OrderItem>();
        list.add(item1);
        list.add(item2);
		


        Address address = new Address();
        address.setAddressline1("Chakala");
        address.setAddressline2("JB nagar");
        address.setCity("Mumbai");
        address.setCountry("India");
        address.setPostcode("234567");
        
        order.setAddress(address);
	    order.setItems(list);
		orderRepository.save(order);
		
	}
	
	@Test
    void deleteOrder()
	{
		Long id=14L;
        orderRepository.deleteById(id);
    }
	
	
}
