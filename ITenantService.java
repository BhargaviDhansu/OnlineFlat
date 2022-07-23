package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;

public interface ITenantService {

	public String addTenant(Tenant tenant);
	
	public List<Tenant> updateTenant(int tenant_id,int age) throws TenantNotFoundException;
	
	public List<Tenant> deleteTenant(int tenant_id) throws TenantNotFoundException ;
	
	public Tenant viewTenant(int tenant_id) throws TenantNotFoundException;
	
	public List<Tenant> viewAllTenant();
	
	public List<Tenant> validateTenantById(int tenant_Id);
	
}
