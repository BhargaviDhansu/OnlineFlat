package com.cg.ofr.service;


import java.util.List;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;

public interface IFlatService {

	public List<Flat> addFlat(Flat flat);
	
	public List<Flat> updateFlat(Integer flatId, Double cost) throws FlatNotFoundException;
	
	public List<Flat> deleteFlat(Integer flatId) throws FlatNotFoundException;
	
	public Flat viewFlat(Integer flatId) throws FlatNotFoundException;

	public List<Flat> viewAllFlat();
	 
	public List<Flat> findByCostAndAvailability(Double cost,String availability);
	 
}