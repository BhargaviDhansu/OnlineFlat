package com.cg.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.serviceimpl.FlatBookingService;

@SpringBootTest
class FlatBookingTest {

	 @Autowired
	    private FlatBookingService flatbookingService;

	    @MockBean
	    IFlatBookingRepository flatbookingrepository;

	    @InjectMocks
	    FlatBookingService flatbookingservice=new FlatBookingService();


	    static FlatBooking flatbooking = new FlatBooking();


	    static List<FlatBooking>  flatbookingList;
	    static List<FlatBooking>  flatbookingList1;


	    @BeforeAll
	    public static void setUp() {

	        flatbookingList=new ArrayList<>();
	        flatbookingList1=new ArrayList<>();



	        flatbooking.setBookingFromDate(LocalDate.of(2020, 8, 9));
	        flatbooking.setBookingToDate(LocalDate.of(2020, 7, 6));
	        flatbooking.setLocation("Hyderabad");
	        flatbookingList1.add(flatbooking);

	    }

	    @Test
	    void testAddFlatBooking() {
	        Mockito.when(flatbookingrepository.saveAndFlush(flatbooking)).thenReturn(flatbooking);
	        assertNotNull(flatbookingService.addFlatBooking(flatbooking));
	    }

	    @Test
	    void testViewAllFlatBooking() throws FlatBookingNotFoundException{
	        Mockito.when( flatbookingrepository.findAll()).thenReturn(flatbookingList);
	    }

	    

	    
	    @Test
	     void testViewFlatBooking() {
	        Mockito.when(flatbookingrepository.findAll()).thenReturn(flatbookingList1);
	    }

	}