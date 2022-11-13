package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.TicketDetails;

public interface TicketDetailsDao extends JpaRepository<TicketDetails, Integer> {

}