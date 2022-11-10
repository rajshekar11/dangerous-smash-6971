package com.tripmaker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookinId;
	private String bookingType;
	private String description;
	private String bookingTitle;
	private LocalDate bookingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Package packages;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TicketDetails> tickets = new ArrayList<>();
}
