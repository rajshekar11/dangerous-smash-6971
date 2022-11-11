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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	@NotEmpty
	@Size(min = 5, max = 15)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String bookingType;
	@NotEmpty
	@Size(min = 10, max = 20)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String description;
	@NotEmpty
	@Size(min = 5, max = 7)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String bookingTitle;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private LocalDate bookingDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Package packages;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<TicketDetails> tickets = new ArrayList<>();
}
