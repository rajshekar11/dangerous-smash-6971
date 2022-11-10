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
	private String packageName;
	private String packageDescription;
	private String packageType;
	private double packageCost;
	private PaymentDetails paymetnDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	private PaymentDetails payment; 

}
