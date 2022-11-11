package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> validationExceptionHandler(MethodArgumentNotValidException me){
		MyErrorDetails myE=new MyErrorDetails();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage("Validation Error");
		myE.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<MyErrorDetails>(myE,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> busExceptionHandler(BusException be,WebRequest req){
		MyErrorDetails myE=new MyErrorDetails();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(be.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myE,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyErrorDetails> hotelExceptionHandler(HotelException he,WebRequest req){
		MyErrorDetails myE=new MyErrorDetails();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(he.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myE,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RouteException.class)
	public ResponseEntity<MyErrorDetails> routeExceptionHandler(RouteException re,WebRequest req){
		MyErrorDetails myE=new MyErrorDetails();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(re.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myE,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<MyErrorDetails> reportExceptionHandler(ReportException re,WebRequest req){
		MyErrorDetails myE=new MyErrorDetails();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(re.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myE,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> allExceptionHandler(Exception e,WebRequest req){
		MyErrorDetails myE=new MyErrorDetails();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(e.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetails>(myE,HttpStatus.BAD_REQUEST);
	}
	
}
