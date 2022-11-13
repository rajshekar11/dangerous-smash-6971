package com.tripmaker.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class FeedbackExceptionHandler {
	
	
	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyErrorDetail> OtherExceptionHandler(FeedbackException fe, WebRequest wr){
		MyErrorDetail feedExc = new MyErrorDetail();
		feedExc.setTimestamp(LocalDateTime.now());
		feedExc.setMessage(fe.getMessage());
		feedExc.setDescription(wr.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(feedExc,HttpStatus.BAD_REQUEST);
	}
}
