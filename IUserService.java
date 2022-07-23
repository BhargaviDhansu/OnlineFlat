package com.cg.ofr.service;


import java.util.List;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;

public interface IUserService {

	public String addUser(User user);
	
	public List<User> updateUser(Integer userId,String name) throws UserNotFoundException;
	
	public List<User> updatePassword(Integer userId,String newpass) throws UserNotFoundException;
	
	public User viewUser(int userId) throws UserNotFoundException;
	
	public List<User> viewAllUser();
	
	public List<User> validateUser(String userName,String password) throws UserNotFoundException;
	
	 public List<User> removeUser(Integer userId);
}
