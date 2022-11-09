package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Route {

	private Integer routeId;
	private String routeFrom;
	private String routeTo;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private LocalDate doj;
	private String pickupPoint;
	private Double fare;
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "routes")
	private List<TicketDetails> ticketDetails=new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	List<Bus> buses=new ArrayList<>();
	
	
	
}
