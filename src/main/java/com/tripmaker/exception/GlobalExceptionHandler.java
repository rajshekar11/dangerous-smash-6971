package com.tripmaker.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;






@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetail> UserExceptionHandler(UserException uException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(uException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetail> CustomerExceptionHandler(CustomerException cException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(cException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<MyErrorDetail> bookingExceptionHandler(BookingException bException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(bException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PackageException.class)
	public ResponseEntity<MyErrorDetail> packageExceptionHandler(PackageException pException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<MyErrorDetail> paymentExceptionHandler(PaymentException pyException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(pyException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TicketDetailsException.class)
	public ResponseEntity<MyErrorDetail> ticketDetailsExceptionHandler(TicketDetailsException tiException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(tiException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TravelException.class)
	public ResponseEntity<MyErrorDetail> ticketExceptionHandler(TravelException tException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(tException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ReportException.class)
	public ResponseEntity<MyErrorDetail> ReportExceptionHandler(ReportException tException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(tException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetail> LoginExceptionHandler(LoginException tException, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(tException.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(Exception se, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetail> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req) {
		MyErrorDetail err=new MyErrorDetail(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetail> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyErrorDetail err=new MyErrorDetail(LocalDateTime.now(),"Validation Error",me.getBindingResult().getFieldError().getDefaultMessage());
	return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
}
