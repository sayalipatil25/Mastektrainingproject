package com.ecommerce.antique.store.entities;

import java.math.BigDecimal;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productid;
	
	private String productname;
	private String productdescription;
	private String productimage;
	private BigDecimal price;
	private int discountpercent;
	private double discountprice;
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
	@JsonIgnore
	private Category category;
	
	

	// unidirectional mapping - it will join table from one side
	// mappedBy means FK managed by other side of relationship
    // @OneTMany - behaves lazy while retrieval of object at many sides
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Review> reviews = new ArrayList<Review>();

	
	
	
	// unidirectional mapping - it will join table from one side
	// mappedBy means FK managed by other side of relationship
    // @OneTMany - behaves lazy while retrieval of object at many sides
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////    @JoinColumn(name = "productid")
//    private List<Review> reviews = new ArrayList<Review>();
    
//    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "productid")
//    private List<OrderItem> items = new ArrayList<OrderItem>();
//    
}
