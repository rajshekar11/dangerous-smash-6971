package com.masai.service;

import java.util.List;

import com.masai.exception.BookingException;
import com.masai.model.Booking;

public interface BookingService {

	public Booking makeABooking(Booking bkg,Integer packageId) throws BookingException;
	
	public Booking cancelBookingById(Integer bookingId) throws BookingException;
	
	public Booking viewBookingById(Integer bookingId) throws BookingException;
	
	public List<Booking> viewAllBooking() throws BookingException;
}
