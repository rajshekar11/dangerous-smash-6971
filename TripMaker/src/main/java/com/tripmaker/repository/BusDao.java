package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.Bus;

public interface BusDao extends JpaRepository<Bus, Integer>{

}