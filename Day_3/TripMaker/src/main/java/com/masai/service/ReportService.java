package com.masai.service;

import java.util.List;

import com.masai.exception.PackageException;
import com.masai.exception.ReportException;
import com.masai.model.Report;

public interface ReportService {

	public Report addAnewReport(Report rpr) throws ReportException;
	
	public Report deleteReportById(Integer reportId) throws ReportException;
	
	public Report searchReportById(Integer reportId) throws ReportException;
	
	public List<Report> getAllReports() throws ReportException;
}
