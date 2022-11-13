package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.CurrentAdmin;

@Repository
public interface CurrentAdminRepository extends JpaRepository<CurrentAdmin, Integer>{

	CurrentAdmin findByUuid(String uuid);
	
}
