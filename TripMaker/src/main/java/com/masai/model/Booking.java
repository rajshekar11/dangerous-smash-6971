package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {

	private Integer bookingId;
	private String bookingType;
	private String description;
	private String bookingTitle;
	private LocalDate bookingDate;
	
//	@ManyToOne
//	private List<User> users=new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Package packageDetails;
	
}
