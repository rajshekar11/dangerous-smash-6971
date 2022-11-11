package com.tripmaker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class TicketDetails {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	
	@NotNull(message = "Status is mandatory")
	@NotEmpty(message = "Status is mandatory")
	@Size(min = 5, max = 50, message = "Description should be of 5-50 charecters")
	@Pattern(regexp = "^[A-Z][a-z]*", message = "Only alphabets are allowed")
	private String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Booking bookings;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Package packages;
	
}
