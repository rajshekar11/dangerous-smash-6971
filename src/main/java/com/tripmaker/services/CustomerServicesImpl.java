package com.tripmaker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.CustomerException;
import com.tripmaker.model.Customer;
import com.tripmaker.repository.CustomerRepository;

//Yedhu Nanthan.S
@Service
public class CustomerServicesImpl implements CustomerServices{

	@Autowired
	private CustomerRepository customerDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer newCoustomer = customerDao.save(customer);
		if(newCoustomer == null)
			throw new CustomerException("cannot insert record");	
		return newCoustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> oC = customerDao.findById(customer.getCustomerId());
		Customer oldcustomer = oC.get();
		if(oldcustomer == null)
			throw new CustomerException("Customer not found with id "+customer.getCustomerId());
		else 
			return customerDao.save(customer);
		
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {
		Optional<Customer> oC = customerDao.findById(customer.getCustomerId());
		Customer oldcustomer = oC.get();
		if(oldcustomer == null)
			throw new CustomerException("Customer not found with id "+customer.getCustomerId());
		else {
			customerDao.delete(customer);
			return customer;
		}
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> oC = customerDao.findById(customerId);
		Customer customer = oC.get();
		if(customer == null)
			throw new CustomerException("Customer not found with id "+ customerId);
		else 
			return customer;
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		List<Customer> customersList = customerDao.findAll();
		if(customersList.size() == 0)
			throw new CustomerException("no customers found");
		else
			return customersList;
	}

}
