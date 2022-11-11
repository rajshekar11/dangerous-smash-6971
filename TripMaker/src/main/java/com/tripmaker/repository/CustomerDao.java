package com.tripmaker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	public Customer findByMobile(String string);
}