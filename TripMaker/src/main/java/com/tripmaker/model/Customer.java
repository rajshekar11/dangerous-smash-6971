package com.tripmaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String email;
	private String address;
	private String mobile;
	private String password;;
	private String userType;
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Feedback> feedbacks = new ArrayList<>();
//	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Booking> bookings = new  ArrayList<>();	
	
}
