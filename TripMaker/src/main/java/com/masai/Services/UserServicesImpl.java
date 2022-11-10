package com.masai.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.UserDao;
import com.masai.Exception.UserException;
import com.masai.been.User;
@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserDao userDao;
	@Override
	public User addNewUser(User user) throws UserException {
		User newuser = userDao.save(user);
		if(newuser == null)
			throw new UserException("cannot insert record");
		else
			return newuser;
	}

	@Override
	public User signIn(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
