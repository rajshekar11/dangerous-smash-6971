package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tripmaker.model.Package;

public interface PackageDAO extends JpaRepository<Package, Integer>{

}
