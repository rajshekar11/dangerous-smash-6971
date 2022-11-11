package com.tripmaker.services;

import java.util.List;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.model.Customer;


public interface CustomerServices {

	public Customer addCustomer(Customer customer)throws CustomerException;
	public Customer updateCustomer(Customer customer)throws CustomerException;
	public Customer deleteCustomer(Customer customer)throws CustomerException;
	public Customer viewCustomer(Integer customerId)throws CustomerException;
	public List<Customer> viewAllCustomer(Integer customerId)throws CustomerException;
	public List<Customer> viewAllCustomerList(Integer customerId)throws CustomerException;
}
