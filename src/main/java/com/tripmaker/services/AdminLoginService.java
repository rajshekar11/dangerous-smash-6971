package com.tripmaker.services;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.AdminLoginDTO;
import com.tripmaker.model.User;


public interface AdminLoginService {

	public User logIntoAccount(AdminLoginDTO adminDTO)throws LoginException;

	public User logOutAccount(Integer userId)throws LoginException;
}
