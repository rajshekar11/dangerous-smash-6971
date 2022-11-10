package com.masai.Services;

import com.masai.Exception.UserException;
import com.masai.been.User;

public interface UserServices {

	public User addNewUser(User user) throws UserException;
	public User signIn(User user) throws UserException; 
	public User signOut(User user) throws UserException; 
 }
