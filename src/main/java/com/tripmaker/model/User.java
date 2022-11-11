package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String UserType;
	private String Password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Customer> customersList = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Travels> travelsList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Admin> adminList = new ArrayList<>();
}
