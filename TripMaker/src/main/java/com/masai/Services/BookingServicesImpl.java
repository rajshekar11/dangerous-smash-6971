package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.BookingDao;
import com.masai.Exception.BookingException;
import com.masai.been.Booking;

@Service
public class BookingServicesImpl implements BookingServices{
	
	@Autowired
	private BookingDao bookingDao;

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
	public List<Booking> makeBooking() throws BookingException {
		List<Booking> bookingList = bookingDao.findAll();
		if(bookingList.size() == 0)
			throw new BookingException("no booking found");
		else
			return bookingList;
	}

}
