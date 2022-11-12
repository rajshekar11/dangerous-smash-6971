package com.tripmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.exception.LoginException;
import com.tripmaker.model.Customer;
import com.tripmaker.services.CustomerServices;

//Yedhu Nanthan.S
@RestController
public class CustomerController {
	

	@Autowired
	private CustomerServices customerServices;
	
	@PostMapping("/Customers/{uuid}")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer, @PathVariable("uuid") String key) throws CustomerException, LoginException{
		Customer newCustomer = customerServices.addCustomer(customer,key);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/Customers/{uuid}")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer, @PathVariable("uuid") String key) throws CustomerException, LoginException{
		Customer updatedCustomer = customerServices.updateCustomer(customer,key);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/Admin/Customers/{uuid}")
	public ResponseEntity<Customer> deleteCustomerHandler(@RequestBody Customer customer, @PathVariable("uuid") String key) throws CustomerException, LoginException{
		Customer deletedCustomer = customerServices.updateCustomer(customer,key);
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/Admin/Customers/{uuid}/{id}")
	public ResponseEntity<Customer> viewCustomerHandler( @PathVariable("uuid") String key ,@PathVariable("id") Integer customerId) throws CustomerException, LoginException{
		Customer Customer = customerServices.viewCustomer(customerId,key);
		return new ResponseEntity<Customer>(Customer,HttpStatus.FOUND);
	}
	
	@GetMapping("/Admin/viewAllCustomers/{uuid}")
	public ResponseEntity<List<Customer>> viewAllCustomerHandler( @PathVariable("uuid") String key) throws CustomerException, LoginException{
		List<Customer> customerList = customerServices.viewAllCustomer(key);
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.FOUND);
	}
}
