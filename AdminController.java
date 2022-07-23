package com.cg.ofr.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.service.IFlatService;
import com.cg.ofr.serviceimpl.FlatBookingService;

import com.cg.ofr.serviceimpl.LandlordService;
import com.cg.ofr.serviceimpl.TenantService;
@CrossOrigin(origins="*")
@RestController

public class AdminController {

	
	@Autowired
	private LandlordService ilandlordservice;
	
	@Autowired
	private TenantService itenantservice;
	
	@Autowired
	private FlatBookingService iflatbookingService;
	
	@Autowired
	private IFlatService iflatService;
	
	@Autowired
	private TenantService itenantService;
	


	/*
	 * @GetMapping("/signIn/{message}") public String
	 * signIn(@PathVariable("message")String message) { return
	 * iadminservice.SignIn(message); }
	 */
	
	
	/* @GetMapping("/validateAdmin/{adminId}/{password}") public String
	 validateUser(@PathVariable("adminId")Integer id,@PathVariable ("password")String password) { return
	 iadminservice.validateUser(id,password); }
	 */
	
	
	/* @GetMapping("/signOut/{message}") public String
	 signOut(@PathVariable("message")String message) { return
	 iadminservice.SignOut(message); }
	*/ 
	
	
	  @PostMapping ("/addLandlord")
	  public List<Landlord> addLandlord(@RequestBody Landlord landlord ) 
	  { System.out.println("request received"); 
	  return ilandlordservice.addLandlord(landlord); }
	 
	
	
	@PutMapping("/updatelandlord/{id}/{newLandlordName}")
	public List<Landlord> updateLandlord(@PathVariable("id") Integer landlordId,@PathVariable("newLandlordName") String landlordName ) throws LandlordNotFoundException{
		return ilandlordservice.updateLandlord(landlordId, landlordName);
		
	}
	
	@DeleteMapping("/deleteLandlord/{id}")
	public List<Landlord> deleteLandlord(@PathVariable ("id") Integer landlordId) throws LandlordNotFoundException{
		return ilandlordservice.deleteLandlord(landlordId);
	}
	
	@PostMapping("/addTenant")
	public String addTenant(@RequestBody Tenant tenant) {
		return itenantservice.addTenant(tenant);
	}
	
	@PutMapping("/updateTenant/{tenant_id}/{age}")
	public List<Tenant> updateTenant(@PathVariable("tenant_id") int tenant_id,@PathVariable("age") int age) throws TenantNotFoundException {
		return itenantservice.updateTenant(tenant_id,age);
	}
	
	@DeleteMapping("/deleteTenant/{tenant_id}")
	public List<Tenant>  deleteTenant(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException {
		return itenantservice.deleteTenant(tenant_id);
	}
	
	@PostMapping("/addFlatBooking")
	public String addFlatBooking(@RequestBody FlatBooking flat){
		
		return iflatbookingService.addFlatBooking(flat);
	}
	
	 @PutMapping("/updateFlatBooking/{id}")
	 
	  public List<FlatBooking> updateFlatBooking(@PathVariable("bookingNo") int bookingNo,@PathVariable("localdate") LocalDate localdate )throws FlatBookingNotFoundException
	   { 
        return iflatbookingService.updateFlatBooking(bookingNo, localdate); 
        }
	 

	 @PostMapping("/addFlat")
		public List<Flat> addFlat(@RequestBody Flat flat) {
			return iflatService.addFlat(flat);
		}
	 
	 @PutMapping("/updateCost/{flatId}/{newcost}")
		public List<Flat>updateCost(@PathVariable("flatId")Integer flatId,@PathVariable("newCost")Double cost) throws FlatNotFoundException{
			return iflatService.updateFlat(flatId,cost);
		}
	 
	 @DeleteMapping("/deleteFlat/{flatId}/{Id}")
		public List<Flat>deleteFlat(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException{
		
			return iflatService.deleteFlat(flatId);
		}
	 
	 @GetMapping("/validateTenantById/{tenant_id}")
		public List<Tenant> validateTenantById(@PathVariable("tenant_id") int tenant_Id) {
			return itenantService. validateTenantById(tenant_Id);
		}

	 
}
