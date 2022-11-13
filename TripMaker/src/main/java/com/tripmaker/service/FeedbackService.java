package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.FeedbackException;
import com.tripmaker.model.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback,Integer coustmerId) throws FeedbackException;
	
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException;
	
	public List<Feedback> viewAllFeedbacks() throws FeedbackException;
	

}
