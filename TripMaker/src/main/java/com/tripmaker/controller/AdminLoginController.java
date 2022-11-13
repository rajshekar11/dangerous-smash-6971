package com.tripmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.LoginException;
import com.tripmaker.model.AdminLoginDTO;
import com.tripmaker.model.CurrentAdmin;
import com.tripmaker.service.AdminLoginService;

@RestController
@RequestMapping("/login")
public class AdminLoginController {
	@Autowired
	private AdminLoginService adminLoginService;

	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentAdmin> loginCustomerr(@RequestBody AdminLoginDTO adminDTO) throws LoginException {
		CurrentAdmin user = adminLoginService.logIntoAccount(adminDTO);
		return new ResponseEntity<CurrentAdmin>(user,HttpStatus.OK);
	}

	@DeleteMapping("/adminLogout/{uuid}")
	public ResponseEntity<CurrentAdmin> logOutCustomerr(@PathVariable("uuid") String key) throws LoginException {
		CurrentAdmin user = adminLoginService.logOutAccount(key);
		return new ResponseEntity<CurrentAdmin>(user, HttpStatus.OK);
		
	}
}
