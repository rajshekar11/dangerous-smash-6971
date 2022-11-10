package com.masai.Services;

import java.util.List;

import com.masai.Exception.BookingException;
import com.masai.been.Booking;

public interface BookingServices {

	public Booking makeBooking(Booking booking)throws BookingException;
	public Booking cancelBooking(Integer bookingId)throws BookingException;
	public Booking virwBooking(Integer bookingId)throws BookingException;
	public List<Booking> makeBooking()throws BookingException;
}
