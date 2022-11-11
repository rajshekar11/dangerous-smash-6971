package com.example.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer paymentId;
	
	@NotNull(message = "Bank Name not be null")
	private String bankName;
	
	@Size(min=12,max=12, message = "Please Enter 12 digit number")
	@NotNull(message = "Card Number Should not be null")
	private String cardNumber;
	private Long netAmount;
	private String paymentStatus;
	private Integer ticketId;
	private Integer customerId;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	private Package packages; 
	
}
