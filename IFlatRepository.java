package com.cg.ofr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ofr.entities.Flat;
@Repository
public interface IFlatRepository extends JpaRepository<Flat,Integer>{

	
	@Query("select f from Flat f where f.cost>=300000 and f.availability='available'")
	

	public List<Flat> findByCostAndAvailability(Double cost, String availability);


	 
	
	 

	
	   

}
