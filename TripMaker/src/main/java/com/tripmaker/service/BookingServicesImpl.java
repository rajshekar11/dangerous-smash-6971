package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.BookingException;
import com.tripmaker.model.Booking;
import com.tripmaker.repository.BookingRepository;


@Service
public class BookingServicesImpl implements BookingServices{
	
	@Autowired
	private BookingRepository bookingDao;

	@Override
	public Booking makeBooking(Booking booking) throws BookingException {
		Booking newbooking = bookingDao.save(booking);
		if(newbooking == null)
			throw new BookingException("cannot insert record");
		else
			return newbooking;
	}

	@Override
	public Booking cancelBooking(Integer bookingId) throws BookingException {
		Optional<Booking> oB = bookingDao.findById(bookingId);
		Booking booking = oB.get();
		if(booking == null)
			throw new BookingException("booking not found");
		else {
			bookingDao.delete(booking);
			return booking;
		}
	}

	@Override
	public Booking virwBooking(Integer bookingId) throws BookingException {
		Optional<Booking> oB = bookingDao.findById(bookingId);
		Booking booking = oB.get();
		if(booking == null)
			throw new BookingException("booking not found");
		else
			return booking;
	}

	@Override
	public List<Booking> viewAllBooking() throws BookingException {
		List<Booking> bookingList = bookingDao.findAll();
		if(bookingList.size() == 0)
			throw new BookingException("no booking found");
		else
			return bookingList;
	}

}
