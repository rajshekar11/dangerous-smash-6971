package com.tripmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.model.Customer;
import com.tripmaker.services.CustomerServices;

@RestController
public class CustomerController {
	

	@Autowired
	private CustomerServices customerServices;
	
	@PostMapping("/Admin/Customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		Customer newCustomer = customerServices.addCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
}
