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

import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.serviceimpl.LandlordService;
@SpringBootTest
class LandlordTest {

	@Autowired
    private LandlordService landlordservice;

    @MockBean
    ILandlordRepository landlordRepository;


    @InjectMocks
    LandlordService landlordService=new LandlordService();

    static Landlord landlord=new Landlord();

    static List<Landlord> landlordList;
    static List<Landlord> landlordList1;


        @BeforeAll
        public static void setUp() {
         Landlord landlord=new Landlord();

         landlordList=new ArrayList<>();
        landlordList1=new ArrayList<>();

        landlord.setLandlordName("Raj");
        landlord.setLandlordAge(40);
        landlordList1.add(landlord);


        }

        @Test
         void testAddLandlord() {
        Mockito.when(landlordRepository.saveAndFlush(landlord)).thenReturn(landlord);
        assertNotNull(landlordservice.addLandlord(landlord));
        }



        @Test
        void testViewAllLandlord() throws LandlordNotFoundException{
            Mockito.when(landlordRepository.findAll()).thenReturn(landlordList);

        }

        @Test
        void testViewLandlord() {
            Mockito.when(landlordRepository.findAll()).thenReturn(landlordList);

        }

    }

