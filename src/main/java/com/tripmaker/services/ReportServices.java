package com.tripmaker.services;

import java.util.List;

import com.tripmaker.exception.ReportException;
import com.tripmaker.model.Report;

//Yedhu Nanthan.S
public interface ReportServices {

	public Report addReport(Report report)throws ReportException;
	public Report deleteReport(Integer reportId)throws ReportException;
	public Report viewReport(Integer reportId)throws ReportException;
	public List<Report> viewAllReport()throws ReportException;
}
