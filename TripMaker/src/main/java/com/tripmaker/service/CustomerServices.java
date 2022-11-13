package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.exception.LoginException;
import com.tripmaker.model.Customer;

//Yedhu Nanthan.S
public interface CustomerServices {

	public Customer addCustomer(Customer customer, String key)throws CustomerException,LoginException;
	public Customer updateCustomer(Customer customer,String key)throws CustomerException,LoginException;
	public Customer deleteCustomer(Customer customer,String key)throws CustomerException,LoginException;
	public Customer viewCustomer(Integer customerId,String key)throws CustomerException,LoginException;
	public List<Customer> viewAllCustomer(String key)throws CustomerException,LoginException;
}
