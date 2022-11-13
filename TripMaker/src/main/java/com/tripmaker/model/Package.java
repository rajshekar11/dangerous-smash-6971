package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class Package {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer packageId;
	
	@NotNull(message = "Package name is mandatory")
	private String packageName;
	
	@NotNull(message = "Package description is mandatory")
	private String packageDescription;
	
	@NotNull(message = "Package type is mandatory")
	private String packageType;
	
	@NotNull(message = "Package cost is mandatory")
	private double packageCost;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private PaymentDetails paymetnDetails;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<TicketDetails> ticket = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Hotel> hotels;
	

}
