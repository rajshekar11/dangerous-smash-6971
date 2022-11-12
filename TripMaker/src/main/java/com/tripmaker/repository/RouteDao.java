package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.Route;


public interface RouteDao extends JpaRepository<Route, Integer> {

}