package com.tripmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.ReportException;
import com.tripmaker.model.Report;
import com.tripmaker.services.ReportServices;

//Yedhu Nanthan.S
@RestController
public class ReportController {

	@Autowired
	private ReportServices reportServices;
	
	@PostMapping("/Reports")
	public ResponseEntity<Report> addReportHandler(@RequestBody Report report) throws ReportException{
		Report newReport = reportServices.addReport(report);
 		return new ResponseEntity<Report>(newReport,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Reports/{id}")
	public ResponseEntity<Report> deleteReportHandler(@PathVariable Integer reportId) throws ReportException{
		Report newReport = reportServices.deleteReport(reportId);
 		return new ResponseEntity<Report>(newReport,HttpStatus.OK);
	}
	
	@GetMapping("/Reports/{id}")
	public ResponseEntity<Report> viewReportHandler(@PathVariable Integer reportId) throws ReportException{
		Report newReport = reportServices.viewReport(reportId);
 		return new ResponseEntity<Report>(newReport,HttpStatus.FOUND);
	}
	
	@GetMapping("/Reports")
	public ResponseEntity<List<Report>> viewAllReportHandler() throws ReportException{
		List<Report> reportList = reportServices.viewAllReport();
 		return new ResponseEntity<List<Report>>(reportList,HttpStatus.FOUND);
	}
}
