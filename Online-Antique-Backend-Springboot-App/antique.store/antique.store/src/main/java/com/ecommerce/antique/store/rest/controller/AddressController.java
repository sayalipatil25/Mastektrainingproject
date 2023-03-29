package com.ecommerce.antique.store.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.Order;
import com.ecommerce.antique.store.services.AddressService;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/address")
	public ResponseEntity<Address> addNewOrder(@RequestBody Address address)
	{
		Address saveAddress =   addressService.newAddress(address);
		return new ResponseEntity<Address>(saveAddress , HttpStatus.CREATED); // CREATED - Http status code - 201
	}
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllOrdersDetails()
	{
		List<Address> address = addressService.getAllOrders();
		return new ResponseEntity<List<Address>> (address,HttpStatus.OK);
	}
	
		
	
}
