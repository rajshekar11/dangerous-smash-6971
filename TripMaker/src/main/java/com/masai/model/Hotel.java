package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel {

	private Integer hotelId;
	private String hotelName;
	private String hotelType;
	private String hotelDescription;
	private String address;
	private Double rent;
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Package> packages=new ArrayList<>();
}
