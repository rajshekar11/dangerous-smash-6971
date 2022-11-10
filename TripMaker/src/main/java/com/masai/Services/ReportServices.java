package com.masai.Services;

import java.util.List;

import com.masai.Exception.ReportException;
import com.masai.been.Report;

public interface ReportServices {
	
	public Report addReport(Report report)throws ReportException;
	public Report deleteReport(Integer reportId)throws ReportException;
	public Report viewReport(Integer reportId)throws ReportException;
	public List<Report> viewAllReport()throws ReportException;
}
