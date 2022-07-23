package com.cg.ofr.service;


import java.util.List;

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;

public interface ILandlordService {

	public List<Landlord> addLandlord(Landlord landlord);
	
	public List<Landlord> updateLandlord(Integer landlordId,String landlordName) throws LandlordNotFoundException;
	
	public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException;
	
	public Landlord viewLandlord(Integer landlordId) throws LandlordNotFoundException;
	
	public List<Landlord> viewAllLandlord();
	
}
