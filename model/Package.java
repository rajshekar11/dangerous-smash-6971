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
	
	@NotEmpty
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String packageName;
	
	@NotEmpty
	@Size(min = 10, max = 20)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String packageDescription;
	
	@NotEmpty
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String packageType;
	private double packageCost;
	
	@NotEmpty
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private PaymentDetails paymetnDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails payment; 

}
