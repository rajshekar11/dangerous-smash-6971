package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.TravelsException;
import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Travels;
import com.tripmaker.model.User;
import com.tripmaker.repository.CustomerSessionDAO;
import com.tripmaker.repository.TravelsDAO;
import com.tripmaker.repository.UserDao;

@Service
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;
	
	@Autowired
	private TravelsDAO travelDAO;
	
	@Autowired
	private UserDao userDao;
	

	@Override
	public Travels addTravels(Travels travel, String key) throws LoginException  {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			Optional<User> loggedInUser = userDao.findById(currUser1.getId());
			
			Travels addedtravel = travelDAO.save(travel);
			return addedtravel;
		}
		else {
			throw new LoginException("Please login to your account");
		}
		
	}

	@Override
	public Travels updateTravel(Travels travel, String key) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			
			Travels addedtravel = travelDAO.save(travel);
			return addedtravel;
			
		}
		else {
			throw new LoginException("Please login to your account");
		}
	}

	@Override
	public String removeTravel(Integer travelId, String key) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			
			Optional<Travels> travel = travelDAO.findById(travelId);
			
			travelDAO.delete(travel.get());
			return "Travel is remove successfully";
		}
		else {
			throw new LoginException("Please login to your account");
		}
	}

	@Override
	public List<Travels> searchTravels(String key) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			
			
			List<Travels> travels = travelDAO.findAll();
			
			return travels;
		}
		throw new LoginException("Please login to your account");
	}

	

}
