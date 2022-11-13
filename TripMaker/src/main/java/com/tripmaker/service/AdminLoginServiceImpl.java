package com.tripmaker.service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.Admin;
import com.tripmaker.model.AdminLoginDTO;
import com.tripmaker.model.CurrentAdmin;
import com.tripmaker.repository.AdminRepository;
import com.tripmaker.repository.CurrentAdminRepository;

import net.bytebuddy.utility.RandomString;;

@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private AdminRepository adminRepository;
		
	@Autowired
	private CurrentAdminRepository currentUserRepository;
	
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
			String key = RandomString.make(4);
			return currentUserRepository.save(new CurrentAdmin(admin.getAdminId(), "Admin", LocalDateTime.now(), key));
		} else {
			throw new LoginException( "Please Enter valid password.");
		}
	}

	@Override
	public CurrentAdmin logOutAccount(String uuid) throws LoginException{
		CurrentAdmin currentAdmin = currentUserRepository.findByUuid(uuid);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + uuid);
		else {
			currentUserRepository.delete(currentAdmin);
			return currentAdmin;
		}
			
	}

	
}
