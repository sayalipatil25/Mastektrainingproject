package com.ecommerce.antique.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.Order;
import com.ecommerce.antique.store.entities.OrderItem;
import com.ecommerce.antique.store.repository.AddressRepository;
import com.ecommerce.antique.store.repository.OrderRepository;



@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	


	// retrieve a order object along with its shipping order
	
		public Order retrieveOrderDetails(long orderid) {
			
			Optional<Order> optional =  orderRepository.findById(orderid);
			
			if(optional.isPresent()) {
				return optional.get();
			}
			
			return null;
		}
		
		//persist order object along with shipping order
		//this method will be called with a POST request
		public Order newOrder(Order order) 
		{

			Address address=order.getAddress();
		//	address.setOrder(order);
			addressRepository.save(address);

			List<OrderItem> items = order.getItems();
			for (OrderItem orderItem : items)
			{
				orderItem.setOrder(order);
				// itemRepository.save(orderItem);
			}
			order.setAddress(address);
			Order newOrder = orderRepository.save(order);
			return newOrder;
		}
		
		
		public List<Order> getAllOrders()
		{
			List<Order> orders=orderRepository.findAll();
			return orders;
			
		}
		
		
		 //delete review records
		public boolean delete(long id) {
		    var removed = orderRepository.removeIf(id);
		    if(removed > 0) {
		        return true;
		    }
		    else {
		        return false;
		    }
		}
		
}
