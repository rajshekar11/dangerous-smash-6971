package com.masai.Services;

import java.util.List;

import com.masai.Exception.CustomerException;
import com.masai.been.Customer;

public interface CustomerServices {

	public Customer addCustomer(Customer customer)throws CustomerException;
	public Customer updateCustomer(Customer customer)throws CustomerException;
	public Customer deleteCustomer(Customer customer)throws CustomerException;
	public Customer viewCustomer(Integer customerId)throws CustomerException;
	public List<Customer> viewAllCustomer(Integer customerId)throws CustomerException;
	public List<Customer> viewAllCustomerList(Integer customerId)throws CustomerException;
	
}
