package com.Blogging.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blogging.Entities.User;
import com.Blogging.Exceptions.UserNotFound;

import com.Blogging.Repository.UserRepo;
import com.Blogging.Service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo urepo;

	@Override
	public User createUser(User user) {
		
		User usersaved=urepo.save(user);
		return usersaved;
	}

	@Override
	public User updateUser(User user, Integer userId) throws UserNotFound {
		Optional<User> uuser=urepo.findById(userId);
		
		if(uuser.isPresent())
		{
			User updated=uuser.get();	
			updated.setName(user.getName());
			updated.setEmail(user.getEmail());
			updated.setPassword(user.getPassword());
			updated.setAbout(user.getAbout());
			
			urepo.save(updated);
			return updated;
		}
		else
		{
			throw new UserNotFound("No user found with this id");
		}
		
	}

	@Override
	public User getUserById(Integer userId) throws UserNotFound {
		// TODO Auto-generated method stub
		
		Optional<User> userwithid=urepo.findById(userId);
		
		if(userwithid.isPresent())
		{
			User user=userwithid.get();		
			return user;
			
		}
		else
		{
			throw new UserNotFound("No user found with this id you have to register user first");
		}
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> allUsers=urepo.findAll();
		
		List<User> users=allUsers.stream().collect(Collectors.toList());
		for(User i:users)
		{
			System.out.println(i.getName());
			System.out.println(i.getEmail());
			System.out.println(i.getAbout());
		}
		return users;
	}

	@Override
	public User deleteUser(Integer userId) throws UserNotFound {
		// TODO Auto-generated method stub
		
		Optional<User> user=urepo.findById(userId);
		if(user.isPresent())
		{
			User deleted=user.get();
			urepo.delete(deleted);
			return deleted;
		}
		else
		{
			throw new UserNotFound("No user found with this id ");
		}
		
		
	}
	

}
