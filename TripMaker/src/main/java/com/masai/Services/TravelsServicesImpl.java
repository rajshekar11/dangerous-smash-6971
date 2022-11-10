package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.TravelsDao;
import com.masai.Exception.TravelsException;
import com.masai.been.Travels;
@Service
public class TravelsServicesImpl implements TravelsServices{

	@Autowired
	private TravelsDao travelsDao;
	
	@Override
	public Travels addTravels(Travels travels) throws TravelsException {
		Travels newTravels = travelsDao.save(travels);
		if(newTravels == null)
			throw new TravelsException("cannot insert record");
		else
			return newTravels;
	}

	@Override
	public Travels updateTravels(Travels travels) throws TravelsException {
		Optional<Travels> oT = travelsDao.findById(travels.getTravelId());
		Travels oldtravels = oT.get();
		if(oldtravels == null)
			throw new TravelsException("No detail in the id " +travels.getTravelId());
		else 
			return travelsDao.save(travels);
			
	}

	@Override
	public Travels removeTravels(Integer travelId) throws TravelsException {
		Optional<Travels> oT = travelsDao.findById(travelId);
		Travels oldtravels = oT.get();
		if(oldtravels == null)
			throw new TravelsException("No detail in the id " +travelId);
		else {
			travelsDao.delete(oldtravels);
			return oldtravels;
		}
	}

	@Override
	public Travels searchTravels(Integer travelId) throws TravelsException {
		Optional<Travels> oT = travelsDao.findById(travelId);
		Travels travels = oT.get();
		if(travels == null)
			throw new TravelsException("No detail in the id " +travelId);
		else 
			return travels;
	}

	@Override
	public List<Travels> viewTravels() throws TravelsException {
		List<Travels> travelList = travelsDao.findAll();
		if(travelList.size() == 0)
		throw new TravelsException("No records in Travels");
	else 
		return travelList;
	}

}
