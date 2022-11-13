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
import com.tripmaker.exception.HotelException;
import com.tripmaker.model.Bus;
import com.tripmaker.model.Hotel;
import com.tripmaker.service.HotelService;

@RestController
public class HotelController {

	@Autowired
	private HotelService hserv;
	
	@PostMapping("/hotel")
	public ResponseEntity<Hotel> addAnewHotel(@RequestBody Hotel hotel) throws HotelException{
		Hotel savedHotel= hserv.addHotel(hotel);
		
		return new ResponseEntity<Hotel>(savedHotel,HttpStatus.CREATED);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> searchHotelById(@PathVariable("hotelId") Integer hotelId) throws HotelException{
		Hotel hotel= hserv.searchHotelById(hotelId);
		
		return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
	}
	
	@DeleteMapping("/hotel/{hotelId}")
	public ResponseEntity<Hotel> deleteHotelById(@PathVariable("hotelId") Integer hotelId) throws HotelException{
		Hotel hotel= hserv.deleteHotelById(hotelId);
		
		return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
	}
	
	@GetMapping("/hotel")
	public ResponseEntity<List<Hotel>> viewAllHotels() throws HotelException{
		List<Hotel> li= hserv.getAllHotels();
		
		return new ResponseEntity<List<Hotel>>(li,HttpStatus.OK);
	}
	
	@PutMapping("/hotelUpdate")
	public ResponseEntity<Hotel> updateBus(@Valid @RequestBody Hotel hotel) throws HotelException{
		Hotel updated= hserv.updateHotel(hotel);
		
		return new ResponseEntity<Hotel>(updated,HttpStatus.CREATED);
	}
}
