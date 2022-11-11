package com.tripmaker.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.Admin;
import com.tripmaker.model.AdminLoginDTO;
import com.tripmaker.model.CurrentAdmin;
import com.tripmaker.repository.AdminRepository;
import com.tripmaker.repository.CurrentUserRepository;;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private AdminRepository adminRepository;
		
	@Autowired
	private CurrentUserRepository currentUserRepository;
	
	@Override
	public CurrentAdmin logIntoAccount(AdminLoginDTO adminDTO) throws LoginException{
		Admin admin = adminRepository.findByEmail(adminDTO.getEmail());
		if (admin == null) {
			throw new LoginException("Please enter valid Email Id!");
		}
		Optional<CurrentAdmin> oC = currentUserRepository.findById(admin.getAdminId());
		if (oC.isPresent()) {
			throw new LoginException( "User already logged in with this number.");
		} 
		if (admin.getPassword().equals(adminDTO.getPassword())) {
			return currentUserRepository.save(new CurrentAdmin(admin.getAdminId(), "Admin", LocalDateTime.now()));
		} else {
			throw new LoginException( "Please Enter valid password.");
		}
	}

	@Override
	public CurrentAdmin logOutAccount(Integer userId) throws LoginException{
		Optional<CurrentAdmin> oC = currentUserRepository.findById(userId);
		if(!oC.isPresent())
			throw new LoginException( "User does not exist by id" + userId);
		else {
			currentUserRepository.delete(oC.get());
			return oC.get();
		}
			
	}

	
}
