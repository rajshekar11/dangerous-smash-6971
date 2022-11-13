package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
