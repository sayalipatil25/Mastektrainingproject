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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderid;
	//private String ordertrackingno;
	private int orderitemquantity;
	private double totalprice;
	
	
	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid")
	//@JsonIgnore
	private User user;
	
	
	
	 @OneToOne(cascade = CascadeType.ALL)  //this will update both address and order tables
	 @JoinColumn(name = "addressid", referencedColumnName = "addressid")
	 //@JsonIgnore
     private Address address;
	 
	 
	 @OneToMany(mappedBy="order", cascade = CascadeType.PERSIST  , fetch = FetchType.EAGER)
	  private List<OrderItem> items = new ArrayList<OrderItem>();
	 
}

