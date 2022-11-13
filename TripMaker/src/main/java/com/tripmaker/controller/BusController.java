package com.tripmaker.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.tripmaker.exception.BusException;
import com.tripmaker.model.Bus;
import com.tripmaker.service.BusService;

@RestController
public class BusController {

	@Autowired
	private BusService bService;
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> addAnewBus(@Valid @RequestBody Bus bus) throws BusException{
		Bus addedBus= bService.addAnewBus(bus);
		
		return new ResponseEntity<Bus>(addedBus,HttpStatus.CREATED);
	}
	
	@GetMapping("/bus/{busId}")
	public ResponseEntity<Bus> searchBusById(@PathVariable("busId") Integer busId) throws BusException{
		Bus bus= bService.searchBusById(busId);
		
		return new ResponseEntity<Bus>(bus,HttpStatus.OK);
	}
	
	@DeleteMapping("/bus/{busId}")
	public ResponseEntity<Bus> deleteBusById(@PathVariable("busId") Integer busId) throws BusException{
		Bus bus= bService.deleteBusById(busId);
		
		return new ResponseEntity<Bus>(bus,HttpStatus.OK);
	}
	
	@GetMapping("/bus")
	public ResponseEntity<List<Bus>> viewAllBuses() throws BusException{
		List<Bus> li= bService.getAllBuses();
		
		return new ResponseEntity<List<Bus>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/bus")
	public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus) throws BusException{
		Bus addedBus= bService.updateBus(bus);
		
		return new ResponseEntity<Bus>(addedBus,HttpStatus.CREATED);
	}
}
