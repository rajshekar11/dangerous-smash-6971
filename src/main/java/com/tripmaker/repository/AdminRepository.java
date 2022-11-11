package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
