package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.ReportException;
import com.tripmaker.model.Report;

//Yedhu Nanthan.S
public interface ReportServices {

	public Report addReport(Report report, String key)throws ReportException, LoginException;
	public Report deleteReport(Integer reportId, String key)throws ReportException, LoginException;
	public Report viewReport(Integer reportId, String key)throws ReportException, LoginException;
	public List<Report> viewAllReport(String key)throws ReportException, LoginException;
}
