package com.cg.ofr.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;

@ControllerAdvice
public class ExceptionController {

		@ExceptionHandler(value=LandlordNotFoundException.class)
		public ResponseEntity<Object> landlordExceptionHandler(Exception ex){
			return new ResponseEntity("Landlord Not Found",HttpStatus.NOT_FOUND);
		}
	
		@ExceptionHandler(value=FlatNotFoundException.class)
		public ResponseEntity<Object>FlatCodeExceptionHandler(Exception ex){

			  return new ResponseEntity("Flat Not Found",HttpStatus.NOT_FOUND);
			  }
}
