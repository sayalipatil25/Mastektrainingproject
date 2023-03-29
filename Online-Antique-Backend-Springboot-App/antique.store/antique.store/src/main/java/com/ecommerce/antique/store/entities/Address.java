package com.ecommerce.antique.store.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressid;
	private String addressline1;
	private String addressline2;
	private String city;
	private String country;
	private String postcode;
	
//
//	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "addressid")
//   private List<Order> orders = new ArrayList<Order>();
	

}

