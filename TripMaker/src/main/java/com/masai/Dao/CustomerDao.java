package com.masai.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.been.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);
	public List<Customer> findbyCustomerId(Integer customerId);
}
