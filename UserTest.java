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

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;
import com.cg.ofr.serviceimpl.UserService;
@SpringBootTest
class UserTest {

	@Autowired
	private UserService userService;
	
	@MockBean
	IUserRepository userrepository;
	
	@InjectMocks
	UserService userservice=new UserService();
	
	
	static User user  = new User();
	
	
	static List<User>  userList;
	static List<User>  userList1;
	
	@BeforeAll
	public static void setUp() {
		
		userList=new ArrayList<>();
		userList1=new ArrayList<>();
		
		
		
		user.setUserName("Harika");
		user.setUserType("Admin");
		user.setPassword("niha");
		userList1.add(user);
		
	}
	
	@Test
	void testAddUser() {
		Mockito.when(userrepository.saveAndFlush(user)).thenReturn(user);
		assertNotNull(userService.addUser(user));
	}
	
	
	@Test
	void testViewUser() 
			throws UserNotFoundException{
		Mockito.when( userrepository.findAll()).thenReturn(userList);
	}

	

	
	@Test
	 void testViewAllUser() {
		Mockito.when(userrepository.findAll()).thenReturn(userList1);
	}

	

}


