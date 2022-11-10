package com.tripmaker.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	private String paymentType;
	private LocalDateTime paymentDateTime;

}
