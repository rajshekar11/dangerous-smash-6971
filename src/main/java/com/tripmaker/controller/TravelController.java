package com.tripmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;
import com.tripmaker.model.TravelsDTO;
import com.tripmaker.services.TravelsServices;

@RestController
public class TravelController {

	@Autowired
	private TravelsServices travelsServices;
	
	@PostMapping("/Admin/Travels/{uuid}")
	public ResponseEntity<Travels> addTravelHandler(@RequestBody TravelsDTO travels, @PathVariable("uuid") String key)throws TravelsException, LoginException{
		Travels newTravels = travelsServices.addTravels(travels,key);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.CREATED);	
	}
	
	@PutMapping("/Admin/Travels/{uuid}")
	public ResponseEntity<Travels> updateTravelHandler(@RequestBody Travels travels,@PathVariable("uuid") String key)throws TravelsException, LoginException{
		Travels newTravels = travelsServices.updateTravels(travels,key);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.OK);
	}
	
	@DeleteMapping("/Admin/Travels/{uuid}/{id}")
	public ResponseEntity<Travels> removeTravelHandler(@PathVariable("uuid") String key,@PathVariable("id") Integer travelsId)throws TravelsException, LoginException{
		Travels newTravels = travelsServices.removeTravels(travelsId,key);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.OK);
	}
	
	@GetMapping("/Travels/{uuid}/{id}")
	public ResponseEntity<Travels> searchTravelHandler(@PathVariable("uuid") String key,@PathVariable("id") Integer travelsId)throws TravelsException, LoginException{
		Travels newTravels = travelsServices.searchTravels(travelsId,key);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.FOUND);
	}
	
	@GetMapping("/Travels/{uuid}")
	public ResponseEntity<List<Travels>> viewTravelHandler(@PathVariable("uuid") String key)throws TravelsException, LoginException{
		List<Travels> travelsList = travelsServices.viewTravels(key);
		return new ResponseEntity<List<Travels>>(travelsList,HttpStatus.FOUND);
	}
	
}
