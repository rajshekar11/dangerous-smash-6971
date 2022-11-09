package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bus {

	private Integer busId;
	private String busType;
	private String busNumber;
	private Integer capacity; 
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	List<Travels> travels=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "buses")
	List<Route> routes=new ArrayList<>();
	
}
