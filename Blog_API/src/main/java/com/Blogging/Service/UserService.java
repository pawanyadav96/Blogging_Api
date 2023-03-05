package com.Blogging.Service;

import java.util.List;

import com.Blogging.Entities.User;
import com.Blogging.Exceptions.UserNotFound;
import com.Blogging.Payloads.UserDto;

public interface UserService {
	
	
//	we are taking here dto insted of entities because we just want to use entities as database 
	public User createUser(User user);
	
	public User updateUser(User user,Integer userId) throws UserNotFound;
	
	public User getUserById(Integer userId) throws UserNotFound;
	
	public List<User> getAllUsers();
	
	public User deleteUser(Integer userId) throws UserNotFound;
	
	
	
	
}
