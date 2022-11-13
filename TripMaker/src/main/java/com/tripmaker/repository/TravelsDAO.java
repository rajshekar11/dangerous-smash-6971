package com.tripmaker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Travels;

public interface TravelsDAO extends JpaRepository<Travels, Integer>{

	public List<Travels> findByAgentName(String agentName);
}
