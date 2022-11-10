package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;
	@NotEmpty
	@Size(min = 5, max = 7)
	@Pattern(regexp = "^[A-Z][a-z]*")
	private String busType;
	@NotEmpty
	private String busNumber;
	@NotEmpty
	private Integer capacity; 
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	List<Travels> travels=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "buses")
	List<Route> routes=new ArrayList<>();
	
}
