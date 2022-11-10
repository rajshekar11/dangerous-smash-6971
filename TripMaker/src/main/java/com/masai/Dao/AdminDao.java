package com.masai.Dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.been.Admin;
@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	public Admin findByEmail(String email);
}
