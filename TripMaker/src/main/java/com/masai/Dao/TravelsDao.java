package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.been.Travels;
@Repository
public interface TravelsDao extends JpaRepository<Travels, Integer>{

}
