package com.tripmaker.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.model.Customer;
import com.tripmaker.model.CustomerSigninDTO;
import com.tripmaker.service.CustomerLoginService;
import com.tripmaker.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerLoginService customerLoginService;

	@PostMapping("/")
	public Customer saveCustomer(@Valid @RequestBody CustomerSigninDTO customer) {
		return customerService.createCustomer(customer);
	}

	// to update customer by passing key
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerSigninDTO customer,
			@RequestParam(required = false) String key) {
		customerLoginService.isLoggedInByUUID(key);
		return customerService.updateCustomer(customer, key);
	}
}
