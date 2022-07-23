package com.cg.ofr.exceptionhandler;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;

@ControllerAdvice
public class FlatExceptionController extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers,HttpStatus status,WebRequest request){
		
			
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) ->{
			
			String fileName=((FieldError)error).getField();
			String message=error.getDefaultMessage();
			errors.put(fileName, message);
		});
		return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);
	}
	
	
		@ExceptionHandler(value=FlatNotFoundException.class)
		public ResponseEntity<Object>FlatCodeExceptionHandler(Exception ex){

			  return new ResponseEntity(" Flat Not Found",HttpStatus.NOT_FOUND);
			  }
		
		
		@ExceptionHandler(value=FlatBookingNotFoundException.class)
		public ResponseEntity<Object>FlatBookingCodeExceptionHandler4(Exception ex){

			  return new ResponseEntity(" FlatBooking Not Found",HttpStatus.NOT_FOUND);
			  }
		
		
		@ExceptionHandler(value=TenantNotFoundException.class)
	    public ResponseEntity<Object> tenantCodeExceptionHandler6(Exception ex) {
	        return new ResponseEntity(" Tenant Not Found" ,HttpStatus.NOT_FOUND);
	    }

	   

	    @ExceptionHandler(value=LandlordNotFoundException.class)
	    public ResponseEntity<Object> LandLordCodeExceptionHandler9(Exception ex) {
	        return new ResponseEntity(" LandLord Not Found" ,HttpStatus.NOT_FOUND);
	    }

	   
	    
	    @ExceptionHandler(value=UserNotFoundException.class)
	    public ResponseEntity<Object> userCodeExceptionHandler12(Exception ex) {
	        return new ResponseEntity("User Not Found",HttpStatus.NOT_FOUND);
	    }

	   
	}
	
