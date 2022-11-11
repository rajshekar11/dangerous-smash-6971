package com.tripmaker.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Customer;
import com.tripmaker.model.CustomerDTO;
import com.tripmaker.repository.CustomerDao;
import com.tripmaker.repository.CustomerSessionDAO;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerDao CustomerDao;

	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;

	@Override
	public String logIntoAccount(CustomerDTO customerDTO) {
		Customer existingCustomer = CustomerDao.findByMobile(customerDTO.getMobile());

		if (existingCustomer == null) {

			throw new LoginException("Please Enter a valid mobile number");

		}

		Optional<CurrentCustomerSession> validCustomerSessionOpt = CustomerSessionDAO.findById(existingCustomer.getCustomerId());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this number");

		}

		if (existingCustomer.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(6);

			CurrentCustomerSession currentUserSession = new CurrentUserSession(existingCustomer.getCustomerId(), key,
					LocalDateTime.now());

			CustomerSessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		} else
			throw new LoginException("Please Enter a valid password");

	}

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();

			CustomerSessionDAO.delete(currUser1);
			return "User logged out successfully.";
		}
		return "User does not exist, Enter correct uuid";
	}

	@Override
	public boolean isLoggedIn(Integer customerId) throws LoginException {
		Optional<CurrentCustomerSession> opt = CustomerSessionDAO.findByUserId(customerId);
		if (opt.isPresent())
			return true;
		else
			throw new LoginException("LogIn first !! ");
	}

	@Override
	public boolean isLoggedInByUUID(String uuid) throws LoginException {
		Optional<CurrentCustomerSession> opt = CustomerSessionDAO.findByUuid(uuid);
		if (opt.isPresent())
			return true;
		else
			throw new LoginException("LogIn first !! ");
	}

}
