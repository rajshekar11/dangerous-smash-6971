package com.masai.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.FeedbackDao;
import com.masai.Exception.FeedbackException;
import com.masai.been.Feedback;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDao feedbackDao;
	
	@Override
	public Feedback addFeeback(Feedback feedback) throws FeedbackException {
		Feedback newFeedback = feedbackDao.save(feedback);
		if( newFeedback == null )
			throw new FeedbackException("cannot insert record");
		else
			return newFeedback;
	}

	@Override
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException {
		Optional<Feedback> oF = feedbackDao.findById(feedbackId);
		Feedback feedback = oF.get();
		if(feedback == null)
			throw new FeedbackException("Feedback not found by id "+ feedbackId);
		else
			return feedback;
	}

	@Override
	public Feedback findByCustomerId(Integer customerId) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() throws FeedbackException {
		List<Feedback> feedbackList = feedbackDao.findAll();
		if(feedbackList.size() == 0)
			throw new FeedbackException("no Feedback found");
		else
			return feedbackList;
	}



}
