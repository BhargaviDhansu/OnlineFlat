package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.serviceimpl.UserService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService iuserservice;


	@PostMapping("/addUser")
	public String addUser(@RequestBody User user ) {
		return iuserservice.addUser(user);		
	}
	
	
	@PutMapping("/updateUser/{id}/{newUser}")
	public List<User> updateUser(@PathVariable("id") Integer userId,@PathVariable("newUser") String name ) throws UserNotFoundException{
		return iuserservice.updateUser(userId,name);
		
	}
	

	@PutMapping("/updatePassword/{id}/{newPassword}")
	public List<User> updatePassword(@PathVariable("id") Integer userId,@PathVariable("newPassword") String password ) throws UserNotFoundException{
		return iuserservice.updateUser(userId,password);
		
	}
	
	@GetMapping("/viewUser/{id}")
	public User viewUser(@PathVariable("id") Integer userId) throws UserNotFoundException{
		return iuserservice.viewUser(userId);
		
	}
	
	@GetMapping("/viewAllUser")
	public List<User> viewAllUser(){
	 return iuserservice.viewAllUser();
	}
	
	
}
