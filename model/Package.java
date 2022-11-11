package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Package {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	
	@NotNull(message = "Package name is mandatory")
	@NotEmpty(message = "Package name is mandatory")
	@Size(min = 5, max = 15, message = "Package name should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String packageName;
	
	@NotNull(message = "Package description is mandatory")
	@NotEmpty(message = "Package description is mandatory")
	@Size(min = 5, max = 50, message = "Description should be of 5-50 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String packageDescription;
	
	@NotNull(message = "Package type is mandatory")
	@NotEmpty(message = "Package type is mandatory")
	@Size(min = 5, max = 15, message = "Package type should be of 5-15 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String packageType;
	
	@NotNull(message = "Package cost is mandatory")
	@NotEmpty(message = "Package type is mandatory")
	@Size(min = 3, max = 5, message = "Package cost should be of 3-5 digits")
	private double packageCost;
	
	@NotEmpty
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails paymetnDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TicketDetails> ticket = new ArrayList<>();
	

}
