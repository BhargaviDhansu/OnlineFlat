package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import com.cg.ofr.service.ITenantService;

@Service
public class TenantService implements ITenantService  {
	@Autowired
	private ITenantRepository tenantRepository;
	
	public String addTenant(Tenant tenant) {
		
		tenantRepository.saveAndFlush(tenant);
		return "Added";
	}
	
public List<Tenant> updateTenant(int tenant_id,int age) throws TenantNotFoundException {
	   
		if(!tenantRepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
		
		}
		
	Tenant tenant=tenantRepository.findById(tenant_id).get();
	
	tenant.setAge(age);
	tenantRepository.flush();
	return tenantRepository.findAll();
}

public List<Tenant> deleteTenant(int tenant_id) throws TenantNotFoundException {
		if(!tenantRepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
	    }	
		tenantRepository.deleteById(tenant_id);	
			return tenantRepository.findAll();
}
	
public Tenant viewTenant(int tenant_id) throws TenantNotFoundException{
	    if(!tenantRepository.existsById(tenant_id)) {
	    	
			throw new TenantNotFoundException();
	    }	
			return tenantRepository.findById(tenant_id).get();
	}	

public List<Tenant> viewAllTenant(){
	return tenantRepository.findAll();
}



public List<Tenant> validateTenantById(int tenant_Id) {
	return tenantRepository.findAll();
}



}



