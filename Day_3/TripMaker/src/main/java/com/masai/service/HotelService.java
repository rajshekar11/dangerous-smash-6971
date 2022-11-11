package com.masai.service;

import java.util.List;

import com.masai.exception.HotelException;
import com.masai.exception.RouteException;
import com.masai.model.Hotel;
import com.masai.model.Route;
import com.masai.model.User;

public interface HotelService {

	public Hotel addHotel(Hotel hotel) throws HotelException;
	
	public Hotel deleteHotelById(Integer hotelId) throws HotelException;
	
	public Hotel searchHotelById(Integer hotelId) throws HotelException;
	
	public List<Hotel> getAllHotels() throws HotelException;

	Hotel updateHotel(Hotel hotel) throws HotelException;
}
