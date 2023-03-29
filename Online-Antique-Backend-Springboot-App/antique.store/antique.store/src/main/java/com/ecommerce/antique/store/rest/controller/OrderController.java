package com.ecommerce.antique.store.rest.controller;

import java.util.List;

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

import com.ecommerce.antique.store.entities.Order;
import com.ecommerce.antique.store.entities.Product;
import com.ecommerce.antique.store.entities.Review;
import com.ecommerce.antique.store.repository.OrderRepository;
import com.ecommerce.antique.store.services.OrderService;
import com.ecommerce.antique.store.services.ProductServices;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	OrderRepository orderRepository;
	
	public OrderController(@Autowired OrderService service) {
		this.orderService = service;
	}
	

	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") long id) {
		Order order = orderService.retrieveOrderDetails(id);
		if(order != null) {
		return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		else
			//throw new ResourceNotFoundException("Order id not found..."); // exception will be displayed as JSON
			return new ResponseEntity<Order>(HttpStatus.NO_CONTENT); // NO_CONTENT - Http status code - 204
	}
	
	
	@PostMapping("/orders")
	public ResponseEntity<Order> addNewOrder(@RequestBody Order order)
	{
		System.out.println(order);
		Order savedOrder =   orderService.newOrder(order);
		return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED); // CREATED - Http status code - 201
	}
	
	@GetMapping("/orderhistory")
	public ResponseEntity<List<Order>> getAllOrdersDetails()
	{
		List<Order> orders = orderService.getAllOrders();
		return new ResponseEntity<List<Order>> (orders,HttpStatus.OK);
	}
	
	
		@DeleteMapping("/delete/order/{id}")
		public ResponseEntity<Order> deleteOrderById(@PathVariable("id") long id) {
			//reviewService.deleteReview(id);
			 boolean complete = orderService.delete(id);
			   if(complete) {
			return new ResponseEntity<Order>(HttpStatus.OK);
		}
	    else {
		      return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		   }
		}
	
		

}
