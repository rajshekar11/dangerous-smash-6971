package com.tripmaker.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.Admin;
import com.tripmaker.model.AdminDTO;
//Yedhu Nanthan.S
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin findByEmail(String email);

	Admin save(AdminDTO admin);
}
