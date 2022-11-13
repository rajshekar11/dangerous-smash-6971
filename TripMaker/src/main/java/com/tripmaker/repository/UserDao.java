package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}