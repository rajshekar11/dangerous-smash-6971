package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travels {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelId;
	
	@NotNull(message = "Travel Name is mandatory")
	@NotEmpty(message = "Travel Name is mandatory")
	@Size(min = 5, max = 15, message = "Travel Name should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String travelName;
	
	@NotNull(message = "Agent Name is mandatory")
	@NotEmpty(message = "Agent Name is mandatory")
	@Size(min = 5, max = 15, message = "agentName should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String agentName;
	
	@NotNull(message = "Address is mandatory")
	@NotEmpty(message = "Address is mandatory")
	@Size(min = 5, max = 15, message = "Address should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String address;
	
	@NotNull(message = "contact is mandatory")
	@NotEmpty(message = "contact is mandatory")
	@Size(min = 10, max = 10, message = "Description should be of 10 digits")
	private String contact;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();

}
