package com.tripmaker.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Yedhu Nanthan.S
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
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	private List<Bus> busList = new ArrayList<>();
//	
//	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "travelsList")
	private List<User> userList = new ArrayList<>();

	public Travels(String travelName, String agentName, String address, String contact) {
		super();
		this.travelName = travelName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}
	
	
}
