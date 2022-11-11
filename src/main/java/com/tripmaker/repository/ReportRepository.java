package com.tripmaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tripmaker.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer>{


}
