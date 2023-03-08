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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Entities.Post;
import com.Blogging.Exceptions.CategoryNotFound;
import com.Blogging.Exceptions.PostNotFound;
import com.Blogging.Exceptions.UserNotFound;
import com.Blogging.Service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/post/")
public class PostController {
	
	@Autowired
	public PostService pservice;
	
	
	@PostMapping("user/{userId}/category/{catId}")
	public ResponseEntity<Post> createpost(@Valid @RequestBody Post post ,@PathVariable Integer userId,@PathVariable Integer catId) throws UserNotFound
	
	{
		Post posts=pservice.createPost(post, userId, catId);
		
		
		return new ResponseEntity<Post>(posts,HttpStatus.CREATED);
		
	}
 @GetMapping("category/{catId}")
 public ResponseEntity<List<Post>> getAllPostByCategoryId(@PathVariable Integer catId)throws CategoryNotFound,PostNotFound
 {
	List<Post> posts= pservice.getPostByCategory(catId);
	return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
 }
 
 
 @GetMapping("user/{userId}")
 public ResponseEntity<List<Post>> getAllPostByUserId(@PathVariable Integer userId)throws PostNotFound, UserNotFound
 {
	List<Post> posts= pservice.getPostByUserId(userId);
	return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
 }

 
 @GetMapping("count/user/{userId}")
 public ResponseEntity<Integer> getNumberofpostDoneByuser(@PathVariable Integer userId)
 {
	Integer i=pservice.countPostByUser(userId);
	return new ResponseEntity<>(i,HttpStatus.OK);
 }
 
 @GetMapping("allPosts")
 public ResponseEntity<List<Post>> getAllPosts(
		 
		 @RequestParam(value ="pageNumber",defaultValue ="1",required =false) Integer pageNumber,
			@RequestParam(value ="pageSize" ,defaultValue ="5" ,required =false)Integer pageSize)
 {
	List<Post>posts=pservice.getAllPost(pageNumber,pageSize);
	return new ResponseEntity<>(posts,HttpStatus.OK);
 }
      @PutMapping("update/{postId}")
      public ResponseEntity<Post> updatePostById(@Valid @RequestBody Post post ,@PathVariable Integer postId) throws PostNotFound
      {
    	  Post p=pservice.updatePost(post, postId);
    	  return new ResponseEntity<Post>(p,HttpStatus.OK);
      }
 @DeleteMapping("delete/{postId}")
 public ResponseEntity<Post> deletePostById(@PathVariable Integer postId) throws PostNotFound

 {
	 Post deletedpost=pservice.deletePost(postId);
	 return new ResponseEntity<Post> (deletedpost,HttpStatus.OK);
 }
 
 
}
