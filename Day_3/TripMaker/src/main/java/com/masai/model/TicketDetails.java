package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Not valid
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TicketDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;
	private String status;
	@OneToOne
	private Package packageDetails;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Route> routes=new ArrayList<>();
	
}
