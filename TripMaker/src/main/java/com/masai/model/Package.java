package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Package {

	private Integer packageId;
	private String packageName;
	private String packageDescription;
	private String packageType;
	private Double packageCost;
//	private Payment paymentDetails;
	
	@OneToOne
	private TicketDetails ticketdetails;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "packages")
	private List<Hotel> hotels=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "packageDetails")
	private List<Booking> bookingDetails=new ArrayList<>();
}
