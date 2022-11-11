package com.tripmaker.services;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.AdminLoginDTO;
import com.tripmaker.model.CurrentAdmin;


public interface AdminLoginService {

	public CurrentAdmin logIntoAccount(AdminLoginDTO adminDTO)throws LoginException;

	public CurrentAdmin logOutAccount(Integer userId)throws LoginException;
}
