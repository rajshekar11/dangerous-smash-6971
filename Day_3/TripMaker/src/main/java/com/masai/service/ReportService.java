package com.masai.service;

import java.util.List;

import com.masai.exception.ReportException;
import com.masai.model.Report;

public interface ReportService {

	public Report addReport(Report report)throws ReportException;
	
	public Report deleteReport(Integer reportId)throws ReportException;
	
	public Report viewReportById(Integer reportId)throws ReportException;
	
	public List<Report> viewAllReport()throws ReportException;
}
