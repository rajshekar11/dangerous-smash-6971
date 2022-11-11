package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.model.Customer;
import com.tripmaker.model.CustomerSigninDTO;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	public Customer updateUser(Customer customer, String key);
	public Customer updateCustomer(Customer customer,String key)throws CustomerException;
	public List<Customer> allCustomer();

}
