package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MyException {

	@ExceptionHandler(TravelsException.class)
	public ResponseEntity<MyError> myTravelsException(TravelsException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyError> myLoginException(TravelsException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyError> myFeedbackException(FeedbackException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> myCustomerException(CustomerException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> myUserException(UserException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<MyError> myReportException(ReportException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyError> myBookingException(BookingException a,WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> myException(Exception a, WebRequest wr){
		MyError my = new MyError();
		my.setTimestamp(LocalDateTime.now());
		my.setMessage(a.getMessage());
		my.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyError>(my,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
		MyError err=new MyError(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyError err=new MyError(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<MyError>(err,HttpStatus.BAD_REQUEST);
	}
}
