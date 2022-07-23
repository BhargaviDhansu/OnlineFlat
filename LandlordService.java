package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.service.ILandlordService;



@Service
public class LandlordService implements ILandlordService  {
	
	@Autowired
	private ILandlordRepository landlordRepository;
	

	public List<Landlord> addLandlord(Landlord landlord) {
		landlordRepository.saveAndFlush(landlord);
		return landlordRepository.findAll();
	}
	
	public List<Landlord> updateLandlord(Integer landlordId,String landlordName) throws LandlordNotFoundException{
		
		if(!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		Landlord landlord = landlordRepository.findById(landlordId).get();
	
		landlord.setLandlordName(landlordName);
		landlordRepository.flush();
		return landlordRepository.findAll();
	}


	public List<Landlord> deleteLandlord(Integer landlordId)throws LandlordNotFoundException{
		if(!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		landlordRepository.deleteById(landlordId);
		return landlordRepository.findAll();
	
	}


	public Landlord viewLandlord(Integer landlordId) throws LandlordNotFoundException{

	if(!landlordRepository.existsById(landlordId)) {
		throw new LandlordNotFoundException();
	}
	return landlordRepository.findById(landlordId).get();
	}


	public List<Landlord> viewAllLandlord(){
		return landlordRepository.findAll();
		}	
}





	/*
	 * public Landlord updateLandlord(Landlord landlord) throws
	 * LandlordNotFoundException; public Landlord deleteLandlord(Landlord landlord)
	 * throws LandlordNotFoundException; public Landlord viewLandlord(int id) throws
	 * LandlordNotFoundException; public List<Landlord> viewAllLandlord();
	 */

