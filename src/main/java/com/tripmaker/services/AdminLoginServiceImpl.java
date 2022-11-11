package com.tripmaker.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.Admin;
import com.tripmaker.model.AdminLoginDTO;
import com.tripmaker.model.User;
import com.tripmaker.repository.AdminRepository;
import com.tripmaker.repository.UserRepository;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public User logIntoAccount(AdminLoginDTO adminDTO) throws LoginException{
		Admin admin = adminRepository.findByEmail(adminDTO.getEmail());
		if (admin == null) {
			throw new LoginException("Please enter valid Mobile number!");
		}
		Optional<User> oU = userRepository.findById(admin.getAdminId());
		User user = oU.get();
		if (user != null) {
			throw new LoginException( "User already logged in with this number.");
		}
		if (admin.getPassword().equals(adminDTO.getPassword())) {
			user = userRepository.save(new User(admin.getAdminId(), "Admin", admin.getPassword(), LocalDateTime.now()));
			return user;
		} else {
			throw new LoginException( "Please Enter valid password.");
		}
	}

	@Override
	public User logOutAccount(Integer userId) throws LoginException{
		Optional<User> oU = userRepository.findById(userId);
		User user = oU.get();
		if(user == null)
			throw new LoginException( "User does not exist by id" + userId);
		else {
			userRepository.delete(user);
			return user;
		}
			
	}

	
}
