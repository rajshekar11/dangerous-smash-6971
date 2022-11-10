package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookingException;
import com.masai.model.Booking;
import com.masai.repository.BookingRepo;
import com.masai.repository.PackageRepo;
@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Autowired
	private PackageRepo packageRepo;
	
	@Override
	public Booking makeABooking(Booking bkg, Integer packageId) throws BookingException {
		// TODO Auto-generated method stub
		
		Optional<Package> pkg= packageRepo.findById(packageId);
		
		
		
		return null;
	}

	
	@Override
	public Booking cancelBookingById(Integer bookingId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Booking viewBookingById(Integer bookingId) throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
