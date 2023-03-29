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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryid;
	private String categoryname;
	private String categorydescription;
	private String categoryimage;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> product = new ArrayList<Product>();

}
