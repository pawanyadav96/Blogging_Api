package com.Blogging.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Entities.User;
import com.Blogging.Exceptions.UserNotFound;
import com.Blogging.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	public UserService uservice;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUserHandler( @Valid @RequestBody User user)
	{
		User createduser=uservice.createUser(user);
		
		return new ResponseEntity<>(createduser,HttpStatus.CREATED);
		
	}
//	pawan
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteuserhandler(@PathVariable Integer id) throws UserNotFound
	{
		User deleteduser=uservice.deleteUser(id);
		 return new ResponseEntity<>(deleteduser,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Integer id) throws UserNotFound

	{
		User user =uservice.getUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserHandler(@Valid @RequestBody User user,@PathVariable Integer id) throws UserNotFound
	{
		User usr=uservice.updateUser(user, id);
		
		return new ResponseEntity<User>(usr,HttpStatus.OK);
		
	}
	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUser() throws UserNotFound

	{
		List<User> users =uservice.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	

}
