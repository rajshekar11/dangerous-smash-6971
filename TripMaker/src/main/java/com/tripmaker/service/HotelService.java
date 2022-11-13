package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.HotelException;
import com.tripmaker.exception.RouteException;
import com.tripmaker.model.Hotel;
import com.tripmaker.model.Route;
import com.tripmaker.model.User;

public interface HotelService {

	public Hotel addHotel(Hotel hotel) throws HotelException;
	
	public Hotel deleteHotelById(Integer hotelId) throws HotelException;
	
	public Hotel searchHotelById(Integer hotelId) throws HotelException;
	
	public List<Hotel> getAllHotels() throws HotelException;

	Hotel updateHotel(Hotel hotel) throws HotelException;
}
