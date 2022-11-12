package com.tripmaker.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	private Integer userId;
	private String UserType;
	private String Password;
	private LocalDateTime localDateTime;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Customer> customersList = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Travels> travelsList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Admin> adminList = new ArrayList<>();
	
	@ManyToMany(cascade =  CascadeType.ALL,mappedBy = "userList")
	private List<Booking> bookingList = new ArrayList<>();

	public User(Integer userId, String userType, String password, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		UserType = userType;
		Password = password;
		this.localDateTime = localDateTime;
	}
	
	
}
