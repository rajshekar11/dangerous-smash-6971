package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.CustomerDao;
import com.masai.Exception.CustomerException;
import com.masai.been.Customer;

@Service
public class CustomerServicesImpl implements CustomerServices{

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Customer newCoustomer = customerDao.save(customer);
		if(newCoustomer == null)
			throw new CustomerException("Customer not found");	
		return newCoustomer;
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> oC = customerDao.findById(customer.getCustomerId());
		Customer oldcustomer = oC.get();
		if(oldcustomer == null)
			throw new CustomerException("Customer not found not found with id "+customer.getCustomerId());
		else 
			return customerDao.save(customer);
		
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws CustomerException {
		Optional<Customer> oC = customerDao.findById(customer.getCustomerId());
		Customer oldcustomer = oC.get();
		if(oldcustomer == null)
			throw new CustomerException("Customer not found not found with id "+customer.getCustomerId());
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
			throw new CustomerException("Customer not found not found with id "+ customerId);
		else 
			return customer;
	}

	@Override
	public List<Customer> viewAllCustomer(Integer customerId) throws CustomerException {
		List<Customer> customersList = customerDao.findbyCustomerId(customerId);
		if(customersList.size() == 0)
			throw new CustomerException("no customers found");
		else
			return customersList;
	}

	@Override
	public List<Customer> viewAllCustomerList(Integer customerId) throws CustomerException {
		List<Customer> customersList = customerDao.findAll();
		if(customersList.size() == 0)
			throw new CustomerException("no customers found");
		else
			return customersList;
	}

}
