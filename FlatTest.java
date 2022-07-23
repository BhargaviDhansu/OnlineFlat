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

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.serviceimpl.FlatService;
@SpringBootTest
class FlatTest {
	 @Autowired
	    private FlatService flatservice;

	    @MockBean
	    IFlatRepository flatRepository;


	    @InjectMocks
	    FlatService  flatService=new FlatService ();

	    static Flat flat=new Flat();

	    static List<Flat> flatList;
	    static List<Flat>flatList1;


	        @BeforeAll
	        public static void setUp() {
	         Flat flat=new Flat();

	         flatList=new ArrayList<>();
	         flatList1=new ArrayList<>();

	        flat.setCost(320000.0);
	      flat.setAvailability("available");
	        flatList1.add(flat);


	        }

	        @Test
	         void testAddFlat() {
	        Mockito.when(flatRepository.saveAndFlush(flat)).thenReturn(flat);
	        assertNotNull(flatservice.addFlat(flat));
	        }



	        @Test
	        void testViewAllFlat() throws FlatNotFoundException{
	            Mockito.when(flatRepository.findAll()).thenReturn(flatList);

	        }

	        @Test
	        void testViewFlat() {
	            Mockito.when(flatRepository.findAll()).thenReturn(flatList);

	        }

	    }



