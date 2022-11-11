package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;

import antlr.collections.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private String paymentStatus;
	private Integer customerId;
	
	@OneToOne(cascade =  CascadeType.ALL)
	private Package packages; 
	
}
