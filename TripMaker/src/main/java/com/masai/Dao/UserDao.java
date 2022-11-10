package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.been.User;
@Repository
public interface UserDao extends JpaRepository<User, Integer>{

}
