
package com.tripmaker.service;

import java.util.List;

import com.tripmaker.model.Customer;
import com.tripmaker.model.CustomerSigninDTO;

public interface CustomerService {

	public Customer createCustomer(CustomerSigninDTO customersigninDto);

	public Customer updateUser(Customer customer, String key);

	public Customer updateCustomer(CustomerSigninDTO customersigninDto, String key);

	public List<Customer> allCustomer();

}