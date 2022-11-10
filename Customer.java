package com.tripmaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String customerPassword;
	private String address;
	private String mobileNo;
	private String email;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

}
