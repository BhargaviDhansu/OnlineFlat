package com.cg.ofr.service;


import java.time.LocalDate;
import java.util.List;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;



public interface IFlatBookingService {

	public String addFlatBooking(FlatBooking flat);
	
	public List<FlatBooking> viewAllFlatBooking();
	
	public List<FlatBooking> updateFlatBooking(int bookingNo, LocalDate localdate) throws
	  FlatBookingNotFoundException;
	 
	public List<FlatBooking> deleteFlatBooking(int bookingNo) throws
	  FlatBookingNotFoundException;
	 
	public FlatBooking viewFlatBooking(int bookingNo) throws
	  FlatBookingNotFoundException;
	 
	 
	
}
