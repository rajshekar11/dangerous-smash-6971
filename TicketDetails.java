package com.tripmaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Booking bookings;
	
}
