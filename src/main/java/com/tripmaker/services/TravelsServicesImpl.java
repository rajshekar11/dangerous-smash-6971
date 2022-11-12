package com.tripmaker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.CurrentAdmin;
import com.tripmaker.model.Travels;
import com.tripmaker.model.TravelsDTO;
import com.tripmaker.repository.CurrentAdminRepository;
import com.tripmaker.repository.TravelsRepository;


@Service
public class TravelsServicesImpl implements TravelsServices{

	@Autowired
	private TravelsRepository travelsDao;
	
	@Autowired
	private CurrentAdminRepository currentAdminRepository;
	@Override
	public Travels addTravels(TravelsDTO travels, String key) throws TravelsException, LoginException {
		
		CurrentAdmin currentAdmin = currentAdminRepository.findByUuid(key);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + key);
		else {
		Travels newTravels = travelsDao.save(new Travels(travels.getTravelName(), travels.getAgentName(), travels.getAddress(), travels.getContact()));
		if(newTravels == null)
			throw new TravelsException("cannot insert record");
		else
			return newTravels;
		}
	}

	@Override
	public Travels updateTravels(Travels travels, String key) throws TravelsException, LoginException {
		
		CurrentAdmin currentAdmin = currentAdminRepository.findByUuid(key);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + key);
		else {
		Optional<Travels> oT = travelsDao.findById(travels.getTravelId());
		Travels oldtravels = oT.get();
		if(oldtravels == null)
			throw new TravelsException("No detail in the id " +travels.getTravelId());
		else 
			return travelsDao.save(travels);
		}
			
	}

	@Override
	public Travels removeTravels(Integer travelId, String key) throws TravelsException, LoginException{
		
		CurrentAdmin currentAdmin = currentAdminRepository.findByUuid(key);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + key);
		else {
		Optional<Travels> oT = travelsDao.findById(travelId);
		Travels oldtravels = oT.get();
		if(oldtravels == null)
			throw new TravelsException("No detail in the id " +travelId);
		else {
			travelsDao.delete(oldtravels);
			return oldtravels;
		}
		}
	}

	@Override
	public Travels searchTravels(Integer travelId, String key) throws TravelsException, LoginException {
		Optional<Travels> oT = travelsDao.findById(travelId);
		Travels travels = oT.get();
		if(travels == null)
			throw new TravelsException("No detail in the id " +travelId);
		else 
			return travels;
	}

	@Override
	public List<Travels> viewTravels( String key) throws TravelsException, LoginException {
		List<Travels> travelList = travelsDao.findAll();
		if(travelList.size() == 0)
		throw new TravelsException("No records in Travels");
	else 
		return travelList;
	}

}
