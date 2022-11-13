package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.FeedbackException;
import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Customer;
import com.tripmaker.model.Feedback;
import com.tripmaker.model.User;
import com.tripmaker.repository.CustomerDao;
import com.tripmaker.repository.CustomerSessionDAO;
import com.tripmaker.repository.FeedbackRepo;
import com.tripmaker.repository.UserDao;

@Service
public class FeedbackServiceImp implements FeedbackService{
	
	@Autowired
	private FeedbackRepo feedbackRepo;
	
	@Autowired
	private CustomerSessionDAO customerSessionDAO;
	
	@Autowired
	private UserDao  userDao;
	
	@Autowired
	private CustomerDao customerDao;

	
	@Override
	public Feedback addFeedback(Feedback feedback, Integer coustmerId) throws FeedbackException {
		// TODO Auto-generated method stub
		
		Optional<CurrentCustomerSession> currentCustomerOptional= customerSessionDAO.findByUserId(coustmerId);
		
		if(!currentCustomerOptional.isPresent())
		{
			throw new FeedbackException("Kindly login first into your account");
		}
		
		CurrentCustomerSession currentCustomerSession = currentCustomerOptional.get();
		
		Customer customer = customerDao.findById(currentCustomerSession.getUserId()).get();
		
		if(customer.getUserType().equals("admin"))
		{
			throw new FeedbackException("Only users can give feedback");
		}
		
		
		feedback.setCustomer(customer);
		
		return feedbackRepo.save(feedback);

	}

	@Override
	public Feedback findByFeedbackId(Integer feedbackId) throws FeedbackException {
		// TODO Auto-generated method stub
		
		Optional<Feedback> feedbackoptional = feedbackRepo.findById(feedbackId);
		
		if(!feedbackoptional.isPresent())
		{
			throw new FeedbackException("No Feedback is present with the given Feedback Id:- "+feedbackId);
		}
		
		return feedbackoptional.get();
	}
		

	@Override
	public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException {

		Optional<CurrentCustomerSession> currentCustomerOptional= customerSessionDAO.findByUserId(customerId);
		
		if(!currentCustomerOptional.isPresent())
		{
			throw new FeedbackException("Please login first into your account !!!");
		}
		
		CurrentCustomerSession currentUserLoginSession=currentCustomerOptional.get();
		
		Customer customer = customerDao.findById(currentUserLoginSession.getUserId()).get();
		
		if(customer.getUserType().equals("User"))
		{
			throw new FeedbackException("This only admin can access this options !!!");
		}
		
		Optional<Customer> customerOptional= customerDao.findById(customerId);
		
		if(!customerOptional.isPresent())
		{
			throw new FeedbackException("No user present with the given customer Id:- "+customerId);
		}
		
		Customer cstReq = customerOptional.get();
		
		List<Feedback> list= cstReq.getFeedbacks();
			if(list.size()==0)
			{
				throw new FeedbackException("No feedbacks made by the customer at all !!!");
			}
		
		return list;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() throws FeedbackException {
		
		List<Feedback> ansList=feedbackRepo.findAll();
		
		return ansList;

	}

}
