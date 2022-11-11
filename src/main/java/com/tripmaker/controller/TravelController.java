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

import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;
import com.tripmaker.model.TravelsDTO;
import com.tripmaker.services.TravelsServices;

@RestController
public class TravelController {

	@Autowired
	private TravelsServices travelsServices;
	
	@PostMapping("/Travels")
	public ResponseEntity<Travels> addTravelHandler(@RequestBody TravelsDTO travels)throws TravelsException{
		Travels newTravels = travelsServices.addTravels(travels);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.CREATED);	
	}
	
	@PutMapping("/Travels")
	public ResponseEntity<Travels> updateTravelHandler(@RequestBody Travels travels)throws TravelsException{
		Travels newTravels = travelsServices.updateTravels(travels);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.OK);
	}
	
	@DeleteMapping("/Travels/{id}")
	public ResponseEntity<Travels> removeTravelHandler(@PathVariable Integer travelsId)throws TravelsException{
		Travels newTravels = travelsServices.removeTravels(travelsId);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.OK);
	}
	
	@GetMapping("/Travels/{id}")
	public ResponseEntity<Travels> searchTravelHandler(@PathVariable Integer travelsId)throws TravelsException{
		Travels newTravels = travelsServices.searchTravels(travelsId);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.FOUND);
	}
	
	@GetMapping("/Travels")
	public ResponseEntity<List<Travels>> viewTravelHandler()throws TravelsException{
		List<Travels> travelsList = travelsServices.viewTravels();
		return new ResponseEntity<List<Travels>>(travelsList,HttpStatus.FOUND);
	}
	
}
