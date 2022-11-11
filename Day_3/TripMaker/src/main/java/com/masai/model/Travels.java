package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@NotNull
	private String travelName;
	
	@NotNull
	private String agentName;
	
	@NotNull
	private String address;
	
	@NotNull
	@Size(min = 10, max = 10)
	private String contact;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<>();

}
