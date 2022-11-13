package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String customerName;
	private String email;
	private String address;
	private String mobile;
	private String password;;
	private String userType;
	

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new  ArrayList<>();

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	//FeedBack List is added
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Feedback> feedbacks = new ArrayList<>();

}