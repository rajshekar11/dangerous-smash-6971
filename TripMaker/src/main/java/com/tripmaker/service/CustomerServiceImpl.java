package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Customer createCustomer(CustomerSigninDTO customersigninDto) {
		Optional<Customer> opt = CustomerDao.findByMobile(customersigninDto.getMobile());
		Customer customer = new Customer();
		customer.setCustomerName(customersigninDto.getCustomerName());
		customer.setPassword(customersigninDto.getPassword());
		customer.setMobile(customersigninDto.getMobile());
		customer.setEmail(customersigninDto.getEmail());
		customer.setAddress(customersigninDto.getAddress());
		customer.setUserType("customer");

		if (opt.isPresent()) {
			System.out.println("User already exist");
		}
		return CustomerDao.save(customer);
	}

	@Override
	public Customer updateUser(Customer customer, String key) {
		Optional<CurrentCustomerSession> optCurrcustomer = CustomerSessionDAO.findByUuid(key);

		if (!optCurrcustomer.isPresent()) {

			throw new RuntimeException("Unauthorised access");
		}

		return CustomerDao.save(customer);
	}

	@Override
	public Customer updateCustomer(CustomerSigninDTO customersigninDto, String key) {
		Optional<CurrentCustomerSession> optCurrcustomer = CustomerSessionDAO.findByUuid(key);
		Customer customer = new Customer();
		customer.setCustomerName(customersigninDto.getCustomerName());
		customer.setPassword(customersigninDto.getPassword());
		customer.setMobile(customersigninDto.getMobile());
		customer.setEmail(customersigninDto.getEmail());
		customer.setAddress(customersigninDto.getAddress());
		customer.setUserType("customer");
		if (!optCurrcustomer.isPresent()) {

			throw new RuntimeException("Unauthorised access");
		}

		return CustomerDao.save(customer);
	}

	@Override
	public List<Customer> allCustomer() {
		return CustomerDao.findAll();
	}

}
