package com.tripmaker.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.BookingException;
import com.tripmaker.model.Booking;
import com.tripmaker.service.BookingServices;


@RestController
public class BookingController {
	
	@Autowired
	private BookingServices bookingServices;

	@PostMapping("/Bookings")
	public ResponseEntity<Booking> makeBookingHandler(@RequestBody Booking booking) throws BookingException{
		Booking newBooking = bookingServices.makeBooking(booking);
		return new ResponseEntity<Booking>(newBooking,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Bookings/{id}")
	public ResponseEntity<Booking> cancelBookingHandler(@PathVariable("id") Integer bookingId) throws BookingException{
		Booking newBooking = bookingServices.cancelBooking(bookingId);
		return new ResponseEntity<Booking>(newBooking,HttpStatus.OK);
	}
	
	@GetMapping("/Bookings/{id}")
	public ResponseEntity<Booking> viewBookingHandler(@PathVariable("id") Integer bookingId) throws BookingException{
		Booking newBooking = bookingServices.virwBooking(bookingId);
		return new ResponseEntity<Booking>(newBooking,HttpStatus.OK);
	}
	
	@GetMapping("/Bookings")
	public ResponseEntity<List<Booking>> viewAllBookingHandler() throws BookingException{
		List<Booking>  bookingList = bookingServices.viewAllBooking();
		return new ResponseEntity<List<Booking>>(bookingList,HttpStatus.OK);
	}
}
