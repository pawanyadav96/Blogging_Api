package com.Blogging.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Entities.Post;
import com.Blogging.Exceptions.UserNotFound;
import com.Blogging.Service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/")
public class PostController {
	
	@Autowired
	public PostService pservice;
	
	
	@PostMapping("user/{userId}/category/{catId}")
	public ResponseEntity<Post> createpost(@Valid @RequestBody Post post ,@PathVariable Integer userId,@PathVariable Integer catId) throws UserNotFound
	
	{
		Post posts=pservice.createPost(post, userId, catId);
		
		
		return new ResponseEntity<Post>(posts,HttpStatus.CREATED);
		
	}

}
