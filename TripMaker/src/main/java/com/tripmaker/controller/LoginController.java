package com.tripmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.model.CustomerDTO;
import com.tripmaker.service.CustomerLoginServiceImpl;

@RestController

@RequestMapping("/login")
public class LoginController {
	@Autowired
	private CustomerLoginServiceImpl customerLoginServiceImpl;

	// for user login
	@PostMapping("/userlogin")
	public String loginCustomerr(@RequestBody CustomerDTO customerDTO) throws Exception {
		return customerLoginServiceImpl.logIntoAccount(customerDTO);
	}

	// for user logout
	@PatchMapping("/userlogout")
	public String logOutCustomerr(@RequestParam(required = false) String key) {
		return customerLoginServiceImpl.logOutAccount(key);
	}
}