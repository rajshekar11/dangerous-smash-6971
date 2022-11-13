package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.exception.LoginException;
import com.tripmaker.model.CurrentAdmin;
import com.tripmaker.model.Customer;
import com.tripmaker.repository.CurrentAdminRepository;
import com.tripmaker.repository.CustomerDao;

//Yedhu Nanthan.S
@Service
public class CustomerServicesImpl implements CustomerServices{

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CurrentAdminRepository currentAdminRepository;

	@Override
	public Customer addCustomer(Customer customer,String key) throws CustomerException {
		
		Customer newCoustomer = customerDao.save(customer);
		if(newCoustomer == null)
			throw new CustomerException("cannot insert record");	
		return newCoustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer,String key) throws CustomerException {
		Optional<Customer> oC = customerDao.findById(customer.getCustomerId());
		Customer oldcustomer = oC.get();
		if(oldcustomer == null)
			throw new CustomerException("Customer not found with id "+customer.getCustomerId());
		else 
			return customerDao.save(customer);
		
	}

	@Override
	public Customer deleteCustomer(Customer customer,String key) throws CustomerException, LoginException {
		
		CurrentAdmin currentAdmin = currentAdminRepository.findByUuid(key);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + key);
		else {
		
		Optional<Customer> oC = customerDao.findById(customer.getCustomerId());
		Customer oldcustomer = oC.get();
		if(oldcustomer == null)
			throw new CustomerException("Customer not found with id "+customer.getCustomerId());
		else {
			customerDao.delete(customer);
			return customer;
		}
		}
	}

	@Override
	public Customer viewCustomer(Integer customerId,String key) throws CustomerException, LoginException {
		CurrentAdmin currentAdmin = currentAdminRepository.findByUuid(key);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + key);
		else {
		Optional<Customer> oC = customerDao.findById(customerId);
		Customer customer = oC.get();
		if(customer == null)
			throw new CustomerException("Customer not found with id "+ customerId);
		else 
			return customer;
		}
	}

	@Override
	public List<Customer> viewAllCustomer(String key) throws CustomerException, LoginException {
		
		CurrentAdmin currentAdmin = currentAdminRepository.findByUuid(key);
		if(currentAdmin == null)
			throw new LoginException( "User does not exist by id" + key);
		else {
		List<Customer> customersList = customerDao.findAll();
		if(customersList.size() == 0)
			throw new CustomerException("no customers found");
		else
			return customersList;
		}
	}

}
