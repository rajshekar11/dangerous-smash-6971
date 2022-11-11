package com.tripmaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByCustomerId(Integer customerId);

}
