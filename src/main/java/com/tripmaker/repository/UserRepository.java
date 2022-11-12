package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
