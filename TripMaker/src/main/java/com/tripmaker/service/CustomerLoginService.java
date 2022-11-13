package com.tripmaker.service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.CustomerDTO;

public interface CustomerLoginService {
	public String logIntoAccount(CustomerDTO customerDTO);

	public String logOutAccount(String key);

	public boolean isLoggedIn(Integer customerId) throws LoginException;

	public boolean isLoggedInByUUID(String uuid) throws LoginException;
}