package com.ecommerce.antique.store.entities;

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

@Entity(name = "review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewid;
	private int rating;
	private String reviewtext;
	
	// getting error in bidirectional mapping
	@ManyToOne
	@JoinColumn(name = "productid", referencedColumnName = "productid", insertable=false, updatable = false)
	@JsonIgnore
	private Product product;
	
	private long productid;
	private long userid;
	
	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid", insertable=false, updatable = false)
	@JsonIgnore
	private User user;
	
	
}
