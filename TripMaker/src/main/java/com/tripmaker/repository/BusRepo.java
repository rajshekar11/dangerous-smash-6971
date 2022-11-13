package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.Bus;
@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

}
