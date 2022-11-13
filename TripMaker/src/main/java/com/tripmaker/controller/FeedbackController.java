package com.tripmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tripmaker.exception.FeedbackException;
import com.tripmaker.model.Feedback;
import com.tripmaker.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/Feedback/add/{key}")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback,@PathVariable("customerId") Integer customerId)throws FeedbackException
	{
		Feedback feedbackReturned=feedbackService.addFeedback(feedback, customerId);
		return new ResponseEntity<Feedback>(feedbackReturned,HttpStatus.CREATED);
	}
	
	@GetMapping("/Feedback/find/{feedbackId}")
	public ResponseEntity<com.tripmaker.model.Feedback> findByFeedbackId(@PathVariable("feedbackId") Integer feedbackId)throws FeedbackException
	{
		Feedback feedbackReturned=feedbackService.findByFeedbackId(feedbackId);
		return new ResponseEntity<Feedback>(feedbackReturned,HttpStatus.CREATED);
	}
	
	@GetMapping("/Feedback/find/{customerId}")
	public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("userId") Integer userId) throws FeedbackException
	{
		List<Feedback> feedbackReturned=feedbackService.findByCustomerId(userId);
		return new ResponseEntity<List<Feedback>>(feedbackReturned,HttpStatus.CREATED);
	}
	
	@GetMapping("/Feedback/findAllFeedback/")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException
	{
		List<Feedback> ansList=feedbackService.viewAllFeedbacks();
		return new ResponseEntity<List<Feedback>>(ansList,HttpStatus.CREATED);
	}
	
}
