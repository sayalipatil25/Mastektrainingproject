package com.ecommerce.antique.store.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "orderitem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderitemid;
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "orderid", referencedColumnName = "orderid")
	@JsonIgnore
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "productid", referencedColumnName = "productid")
	//@JsonIgnore
	private Product product;
}
