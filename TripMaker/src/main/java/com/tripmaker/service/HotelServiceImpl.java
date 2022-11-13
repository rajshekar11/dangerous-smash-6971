package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.BusException;
import com.tripmaker.exception.HotelException;
import com.tripmaker.model.Bus;
import com.tripmaker.model.Hotel;
import com.tripmaker.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepo hRepo;

	@Override
	public Hotel addHotel(Hotel hotel) throws HotelException {
		Optional<Hotel> opt= hRepo.findById(hotel.getHotelId());
		if(opt.isPresent()) {
			throw new HotelException("Hotel with id: "+hotel.getHotelId()+" is present");
		}
		return hRepo.save(hotel);
	}

	@Override
	public Hotel deleteHotelById(Integer hotelId) throws HotelException {
		Optional<Hotel> opt= hRepo.findById(hotelId);
		if(opt.isPresent()) {
			Hotel hotel=opt.get();
			hRepo.delete(hotel);
			return hotel;
		}
		throw new HotelException("There are no hotel with id: "+hotelId);
	}

	@Override
	public Hotel searchHotelById(Integer hotelId) throws HotelException {
		Optional<Hotel> opt= hRepo.findById(hotelId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new HotelException("There are no Hotel with id: "+hotelId);
	}

	@Override
	public List<Hotel> getAllHotels() throws HotelException {
		List<Hotel> li= hRepo.findAll();
		if(li.size()==0) {
			throw new HotelException("There are no busses available currently");
		}
		return li;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) throws HotelException {
		Optional<Hotel> opt= hRepo.findById(hotel.getHotelId());
		if(opt.isPresent()) {
			return hRepo.save(hotel);
		}
		throw new HotelException("Hotel with id: "+hotel.getHotelId()+" is doesnot exits");
	}
	
}
