package com.tripmaker.service;



import java.util.List;

import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.Travels;


public interface TravelService {

	public Travels addTravels(Travels travel , String key) throws TravelsException;
	public Travels updateTravel(Travels travel , String key) throws TravelsException;
	public String removeTravel(Integer travelId, String key) throws TravelsException;
	public List<Travels> searchTravels(String key) throws TravelsException;
}
