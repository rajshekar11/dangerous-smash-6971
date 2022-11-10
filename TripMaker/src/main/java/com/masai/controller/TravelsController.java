package com.masai.controller;

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

import com.masai.Exception.TravelsException;
import com.masai.Services.TravelsServices;
import com.masai.been.Travels;

@RestController
public class TravelsController {

	@Autowired
	private TravelsServices travelsServices;
	
	@PostMapping("/Travels")
	public ResponseEntity<Travels> addTravelsHandler(@RequestBody Travels travels) throws TravelsException{
		Travels newTravels = travelsServices.addTravels(travels);
		return new ResponseEntity<Travels>(newTravels,HttpStatus.CREATED);
	}
	@PutMapping("/Travels")
	public ResponseEntity<Travels> updateTravelsHandler(@RequestBody Travels travels) throws TravelsException{
		Travels updatedTravels = travelsServices.updateTravels(travels);
		return new ResponseEntity<Travels>(updatedTravels,HttpStatus.OK);
	}
	@DeleteMapping("/Travels/{id}")
	public ResponseEntity<Travels> removeTravelsHandler(@PathVariable("id") Integer travelId) throws TravelsException{
		Travels removedTravels = travelsServices.removeTravels(travelId);
		return new ResponseEntity<Travels>(removedTravels,HttpStatus.OK);
	}
	@GetMapping("/Travels/{id}")
	public ResponseEntity<Travels> searchTravelsHandler(@PathVariable("id") Integer travelId) throws TravelsException{
		Travels foundTravels = travelsServices.searchTravels(travelId);
		return new ResponseEntity<Travels>(foundTravels,HttpStatus.FOUND);
	}
	@GetMapping("/Travels")
	public ResponseEntity<List<Travels>> searchTravelsHandler() throws TravelsException{
		List<Travels> travelsList = travelsServices.viewTravels();
		return new ResponseEntity<List<Travels>>(travelsList,HttpStatus.FOUND);
	}
}
