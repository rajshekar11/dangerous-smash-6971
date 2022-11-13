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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.ReportException;
import com.tripmaker.model.Report;
import com.tripmaker.service.ReportServices;


//Yedhu Nanthan.S
@RestController
@RequestMapping("/Admin")
public class ReportController {

	@Autowired
	private ReportServices reportServices;
	
	@PostMapping("/Reports/{uuid}")
	public ResponseEntity<Report> addReportHandler(@RequestBody Report report,@PathVariable("uuid") String key) throws ReportException, LoginException{
		Report newReport = reportServices.addReport(report,key);
 		return new ResponseEntity<Report>(newReport,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Reports/{uuid}/{id}")
	public ResponseEntity<Report> deleteReportHandler(@PathVariable("uuid") String key,@PathVariable("id") Integer reportId) throws ReportException, LoginException{
		Report newReport = reportServices.deleteReport(reportId,key);
 		return new ResponseEntity<Report>(newReport,HttpStatus.OK);
	}
	
	@GetMapping("/Reports/{uuid}/{id}")
	public ResponseEntity<Report> viewReportHandler(@PathVariable("uuid") String key,@PathVariable("id") Integer reportId) throws ReportException, LoginException{
		Report newReport = reportServices.viewReport(reportId,key);
 		return new ResponseEntity<Report>(newReport,HttpStatus.FOUND);
	}
	
	@GetMapping("/Reports/{uuid}")
	public ResponseEntity<List<Report>> viewAllReportHandler(@PathVariable("uuid") String key) throws ReportException, LoginException{
		List<Report> reportList = reportServices.viewAllReport(key);
 		return new ResponseEntity<List<Report>>(reportList,HttpStatus.FOUND);
	}
}
