package com.masai.Services;

import java.util.List;

import com.masai.Exception.TravelsException;
import com.masai.been.Travels;

public interface TravelsServices {

	public Travels addTravels(Travels travels)throws TravelsException;
	public Travels updateTravels(Travels travels)throws TravelsException;
	public Travels removeTravels(Integer travelId)throws TravelsException;
	public Travels searchTravels(Integer travelId)throws TravelsException;
	public List<Travels> viewTravels()throws TravelsException;
	
}
