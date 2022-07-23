package com.cg.ofr.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.User;
import com.cg.ofr.exception.UserNotFoundException;
import com.cg.ofr.repository.IUserRepository;
import com.cg.ofr.service.IUserService;



@Service
public class UserService implements IUserService{
	
	@Autowired
	private IUserRepository userRepository;
	
	public String addUser(User user) {
		userRepository.saveAndFlush(user);
		return "User added";	
		
	}
	
	public List<User> updateUser(Integer userId,String name) throws UserNotFoundException{
		if(!userRepository.existsById(userId)){
			throw new UserNotFoundException();
		}
		User user = userRepository.findById(userId).get();
	
		user.setUserName(name);
		userRepository.flush();
		return userRepository.findAll();
	}
	
	public List<User> updatePassword(Integer userId,String newpass) throws UserNotFoundException{
		if(!userRepository.existsById(userId)){
			throw new UserNotFoundException();
		}
		User user = userRepository.findById(userId).get();
	
		user.setPassword(newpass);
		userRepository.flush();
		return userRepository.findAll();
	}
	
	public User viewUser(int userId) throws UserNotFoundException{
		if(!userRepository.existsById(userId)) {
			throw new UserNotFoundException();
		}
		return userRepository.findById(userId).get();
		}

	public List<User> viewAllUser(){
		return userRepository.findAll();
	}
	
	public List<User> validateUser(String userName,String password) throws UserNotFoundException{
		if(!userRepository.equals(userName)) {
			throw new UserNotFoundException();
		}
		return userRepository.findAll();
	}
	
	
	  public List<User> removeUser(Integer userId) {
	  userRepository.deleteById(userId);
	  	return userRepository.findAll();
	  }
	 
	
	
	
}
	

/*
 * public User viewUser(int id) throws UserNotFoundException; public List<User>
 * viewAllUser(); public User validateUser(String username,String password)
 * throws UserNotFoundException; public User addUser(User user); public User
 * updateUser(User user); public User updatePassword(User user,String newpass);
 * public User removeUser(User user);
 */