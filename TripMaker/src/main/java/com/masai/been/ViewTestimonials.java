package com.example.model;

import javax.persistence.ManyToOne;

public class ViewTestimonials {
	
	private Integer customerId;
	private String feedback;

	@ManyToOne
	private Customer customer;
}
