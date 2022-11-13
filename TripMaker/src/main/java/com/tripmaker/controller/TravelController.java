package com.tripmaker.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;
import com.tripmaker.service.CustomerLoginService;
import com.tripmaker.service.TravelService;

@RestController
@RequestMapping("/travel")
public class TravelController {
	
	@Autowired
	CustomerLoginService customerLoginService;
	
	@Autowired
	TravelService travelService;
	
	@PostMapping("/travel")
	public Travels addTravel(@RequestBody Travels travel, @RequestParam String key) throws TravelsException {
		
		if(customerLoginService.isLoggedInByUUID(key)) {
			return travelService.addTravels(travel, key);
		}
		else {
			throw new LoginException("Please login to youur account");
		}
	}
	
	@PutMapping("/travelupdate")
	public Travels updateTravel(@RequestBody Travels travel, @RequestParam String key) throws TravelsException {
		
		if(customerLoginService.isLoggedInByUUID(key)) {		
			return travelService.updateTravel(travel, key);
		}
		else {
			throw new LoginException("Please login to youur account");
		}
	}
	
	@DeleteMapping("/traveldelete")
	public String deleteTravel(@RequestParam Integer travelId, @RequestParam String key) throws TravelsException {
		
		if(customerLoginService.isLoggedInByUUID(key)) {
			return travelService.removeTravel(travelId, key);
		}
		else {
			throw new LoginException("Please login to youur account");
		}
		
	}
	
	@PostMapping("/gettravel")
	public List<Travels> getAllTravels(@RequestParam String key) throws TravelsException {
		
		if(customerLoginService.isLoggedInByUUID(key)) {
			return travelService.searchTravels(key);
		}
		else {
			throw new LoginException("Please login to youur account");
		}
	}
	

}
