package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketDetails {

	private String ticketId;
	private String status;
	@OneToOne
	private Package packageDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Route> routes=new ArrayList<>();
	
}
