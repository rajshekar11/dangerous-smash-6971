package com.tripmaker.model;

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
public class Travels {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer travelId;
	private String travelName;
	private String agentName;
	private String address;
	private String contact;
}