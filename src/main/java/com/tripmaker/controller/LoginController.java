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
import com.tripmaker.model.User;
import com.tripmaker.services.AdminLoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AdminLoginService adminLoginService;

	@PostMapping("/adminLogin")
	public ResponseEntity<User> loginCustomerr(@RequestBody AdminLoginDTO adminDTO) throws LoginException {
		User user = adminLoginService.logIntoAccount(adminDTO);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

	@DeleteMapping("/adminLogout/{id}")
	public ResponseEntity<User> logOutCustomerr(@PathVariable("id") Integer adminId) throws LoginException {
		User user = adminLoginService.logOutAccount(adminId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
}
