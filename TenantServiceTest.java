package com.cg.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.cg.ofr.entities.Tenant;
//@RunWith(MockitoJUnitRunner.class)
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import com.cg.ofr.serviceimpl.TenantService;


@SpringBootTest
class TenantServiceTest {
	@Autowired
	private TenantService tenantservice;
    @MockBean
    private ITenantRepository tenantRepository;
    
    @InjectMocks
    TenantService tenantService=new TenantService();
    static Tenant tenant=new Tenant();
    
    static List<Tenant> tenantList;
    static List<Tenant> tenantList1;

	
    @BeforeAll
    public static void setUp() {
    	tenantList=new ArrayList<>();
    	tenantList1=new ArrayList<>();
    	
    	
    	
		
		tenant.setAge(45);
		tenantList.add(tenant);
		
		
    }

	@Test
	void testAddTenant() {
		Mockito.when(tenantRepository.saveAndFlush(tenant)).thenReturn(tenant);
		
		
		
	}

	@Test
	void testViewAllTenants() throws TenantNotFoundException {
		Mockito.when(tenantRepository.findAll()).thenReturn(tenantList);
		
	}
	@Test
	void testViewTenants() throws TenantNotFoundException {
		Mockito.when(tenantRepository.findAll()).thenReturn(tenantList);
		
	}
	
}

	

	