package com.tripmaker.services;

import java.util.List;

import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;
import com.tripmaker.model.TravelsDTO;


public interface TravelsServices {

	public Travels addTravels(TravelsDTO travels)throws TravelsException;
	public Travels updateTravels(Travels travels)throws TravelsException;
	public Travels removeTravels(Integer travelId)throws TravelsException;
	public Travels searchTravels(Integer travelId)throws TravelsException;
	public List<Travels> viewTravels()throws TravelsException;
	
}
