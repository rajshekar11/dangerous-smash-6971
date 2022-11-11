package com.masai.model;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@NotNull
	private String UserType;
	@NotNull
	private String Password;
	
	@OneToMany
	private List<Customer> customers = new ArrayList<>();
	
	//We need to add admin as he is also a user. and use ManyToOne mapping.
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
	private List<Travels> travels = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Booking> bookings = new ArrayList<>();
}
