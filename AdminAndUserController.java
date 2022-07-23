package com.cg.ofr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.serviceimpl.FlatBookingService;
import com.cg.ofr.serviceimpl.FlatService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/admin_user")
public class AdminAndUserController {

	

	@Autowired
	private FlatBookingService iflatbookingService;
	
	@Autowired
	private FlatService flatService;
	
	
	
	@GetMapping("/viewFlatById/{flatId}/{Id}")
	public Flat viewFlatById(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException {
		return flatService.viewFlat(flatId);
	}
	
	@GetMapping("/viewAllFlat")
	public List<Flat>viewAllFlat(){
		return flatService.viewAllFlat();
	}

	 
	  @DeleteMapping("/deleteFlatBooking/{id}")
		 
	  public List<FlatBooking> deleteFlatBooking(@PathVariable("bookingNo") int bookingNo)throws FlatBookingNotFoundException
	   { 
         return iflatbookingService.deleteFlatBooking(bookingNo); 
         }
	  
	  @GetMapping("/viewFlatBooking/{id}")
		 
	  public FlatBooking viewFlatBooking(@PathVariable("bookingNo") int bookingNo)throws FlatBookingNotFoundException
	   { 
         return iflatbookingService.viewFlatBooking(bookingNo); 
         }
	  
	  @GetMapping("/viewAllFlatBooking")
		public List<FlatBooking> getAllProducts() {
			
			return iflatbookingService.viewAllFlatBooking();
		}

	  
}
