package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Customer;
import com.tripmaker.model.CustomerSigninDTO;
import com.tripmaker.repository.CustomerDao;
import com.tripmaker.repository.CustomerSessionDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao CustomerDao;

	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer existingCustomer = CustomerDao.findByMobile(customer.getMobile());

		if (existingCustomer != null)
			throw new CustomerException("Customer Already Registered with Mobile number");

		return CustomerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		CurrentCustomerSession loggedInUser = CustomerSessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}

		if (customer.getCustomerId() == loggedInUser.getUserId()) {
			return CustomerDao.save(customer);
		} else
			throw new CustomerException("Invalid Customer Details, please login first");
	}

	@Override
	public Customer updateUser(Customer customer, String key) {
		CurrentCustomerSession optCurrcustomer = CustomerSessionDAO.findByUuid(key);

		if (optCurrcustomer != null) {

			throw new RuntimeException("Unauthorised access");
		}

		return CustomerDao.save(customer);
	}

	@Override
	public List<Customer> allCustomer() {
		return CustomerDao.findAll();
	}


}
