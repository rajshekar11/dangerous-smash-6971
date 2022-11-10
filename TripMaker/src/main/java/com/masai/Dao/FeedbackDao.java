package com.masai.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.been.Feedback;

public interface FeedbackDao extends JpaRepository<Feedback, Integer>{

	
}
