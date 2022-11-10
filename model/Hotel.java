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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer hotelId;
	@NotEmpty
	private String hotelName;
	@NotEmpty
	private String hotelType;
	@NotEmpty
	private String hotelDescription;
	@NotEmpty
	private String address;
	@NotEmpty
	private Double rent;
	@NotEmpty
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Package> packages=new ArrayList<>();
}
