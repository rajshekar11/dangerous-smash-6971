package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.BookingException;
import com.tripmaker.model.Booking;


public interface BookingServices {

	public Booking makeBooking(Booking booking)throws BookingException;
	public Booking cancelBooking(Integer bookingId)throws BookingException;
	public Booking virwBooking(Integer bookingId)throws BookingException;
	public List<Booking> viewAllBooking()throws BookingException;
}
