package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@NotNull(message = "Travel Name is mandatory")
	private String travelName;
	
	@NotNull(message = "Agent Name is mandatory")
	private String agentName;
	
	@NotNull(message = "Address is mandatory")
	private String address;
	
	@NotNull(message = "contact is mandatory")
	private String contact;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Bus> bus = new ArrayList<>();

}
