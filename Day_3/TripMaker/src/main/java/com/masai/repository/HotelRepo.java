package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Hotel;
@Repository
public interface HotelRepo extends JpaRepository<Hotel, Integer> {

}
