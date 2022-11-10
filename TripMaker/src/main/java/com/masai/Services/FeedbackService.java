package com.masai.Services;

import java.util.List;

import com.masai.Exception.FeedbackException;
import com.masai.been.Feedback;

public interface FeedbackService {

	public Feedback addFeeback(Feedback feedback)throws FeedbackException;
	public Feedback findByFeedbackId(Integer feedbackId)throws FeedbackException;
	public Feedback findByCustomerId(Integer customerId)throws FeedbackException;
	public List<Feedback> viewAllFeedbacks()throws FeedbackException;
}
