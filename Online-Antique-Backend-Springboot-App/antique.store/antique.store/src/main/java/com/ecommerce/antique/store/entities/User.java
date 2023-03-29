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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userid;
	private String username;
	private String passwd;
	private String firstname;
	private String lastname;
	private String contactno;
	private boolean administrator;
	
	// error in (mappedby) functionality
	 // mappedBy means FK managed by other side of relationship
    // @OneTMany - behaves lazy while retrieval of object at many sides
	
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "userid")
//    private List<Review> reviews = new ArrayList<Review>();
    
    @OneToOne
	@JoinColumn(name = "addressid", referencedColumnName = "addressid")
    @JsonIgnore
	private Address address;
    
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "userid")
    @JsonIgnore
    private List<Order> orders = new ArrayList<Order>();
    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "userid")
    private List<Review> reviews = new ArrayList<Review>();
    
    
}
