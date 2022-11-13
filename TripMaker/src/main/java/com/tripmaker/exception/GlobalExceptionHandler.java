package com.tripmaker.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;





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
	
	@ExceptionHandler(TravelsException.class)
	public ResponseEntity<MyErrorDetail> ticketExceptionHandler(TravelsException tException, WebRequest req) {
		
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
	
	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetail> busExceptionHandler(BusException be,WebRequest req){
		MyErrorDetail myE=new MyErrorDetail();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(be.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myE,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyErrorDetail> hotelExceptionHandler(HotelException he,WebRequest req){
		MyErrorDetail myE=new MyErrorDetail();
		myE.setTimestamp(LocalDateTime.now());
		myE.setMessage(he.getMessage());
		myE.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(myE,HttpStatus.BAD_REQUEST);
	}
	
	
}
