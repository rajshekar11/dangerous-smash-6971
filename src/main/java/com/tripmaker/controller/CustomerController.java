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
import com.tripmaker.model.Customer;
import com.tripmaker.services.CustomerServices;

//Yedhu Nanthan.S
@RestController
public class CustomerController {
	

	@Autowired
	private CustomerServices customerServices;
	
	@PostMapping("/Customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		Customer newCustomer = customerServices.addCustomer(customer);
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/Customers/")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		Customer updatedCustomer = customerServices.updateCustomer(customer);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@DeleteMapping("/Customers")
	public ResponseEntity<Customer> deleteCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		Customer deletedCustomer = customerServices.updateCustomer(customer);
		return new ResponseEntity<Customer>(deletedCustomer,HttpStatus.OK);
	}
	
	@GetMapping("/Admin/Customers/{id}")
	public ResponseEntity<Customer> viewCustomerHandler(@PathVariable("id") Integer customerId) throws CustomerException{
		Customer Customer = customerServices.viewCustomer(customerId);
		return new ResponseEntity<Customer>(Customer,HttpStatus.FOUND);
	}
	
	@GetMapping("/Admin/viewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomerHandler() throws CustomerException{
		List<Customer> customerList = customerServices.viewAllCustomer();
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.FOUND);
	}
}
