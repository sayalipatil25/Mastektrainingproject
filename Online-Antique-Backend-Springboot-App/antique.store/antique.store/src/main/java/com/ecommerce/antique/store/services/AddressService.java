package com.ecommerce.antique.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.antique.store.entities.Address;
import com.ecommerce.antique.store.entities.Order;
import com.ecommerce.antique.store.repository.AddressRepository;
import com.ecommerce.antique.store.repository.OrderRepository;

@Service
public class AddressService {


	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address newAddress(Address address) {
		Address newAddress = addressRepository.save(address);
		return newAddress;
	}
	
	public List<Address> getAllOrders()
	{
		List<Address> address=addressRepository.findAll();
		return address;
		
	}
	
}
