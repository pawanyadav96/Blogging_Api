package com.Blogging.Controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;

import com.Blogging.Entities.Post;
import com.Blogging.Exceptions.CategoryNotFound;
import com.Blogging.Exceptions.PostNotFound;
import com.Blogging.Exceptions.UserNotFound;
import com.Blogging.Service.Fileupload;
import com.Blogging.Service.PostService;

import jakarta.validation.Valid;
import lombok.Value;

@RestController
@RequestMapping("api/post/")
public class PostController {
	
	@Autowired
	public PostService pservice;
	
	@Autowired
	private Fileupload fupload;
	
	@org.springframework.beans.factory.annotation.Value("${project.image}")
	private String path;
	
	
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
		 
		 @RequestParam(value ="pageNumber",defaultValue ="0",required =false) Integer pageNumber,
			@RequestParam(value ="pageSize" ,defaultValue ="6" ,required =false)Integer pageSize,
           @RequestParam(value = "sortBy",defaultValue ="postId",required =false) String sortBy )
 {
	List<Post>posts=pservice.getAllPost(pageNumber,pageSize,sortBy);
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
 
 @GetMapping("search/{keywords}")
 public ResponseEntity<List<Post>> getPostBytitle(@PathVariable String keywords)
 {
	List<Post> posts=pservice.getPostBykeyword(keywords);
	return new ResponseEntity<>(posts,HttpStatus.OK);
 }
 @PostMapping("/image/upload/{postId}")
 public ResponseEntity<Post> uploadPostImage(@RequestParam ("image")MultipartFile image,@PathVariable Integer postId) throws PostNotFound, IOException
 {
	 
		Post post=pservice.getPostByID(postId);
	String filename= this.fupload.uploadImage(path,image);

	
	post.setImagename(filename);
	
	Post posts=pservice.updatePost(post, postId);
	
	return new ResponseEntity<Post>(posts,HttpStatus.OK);
	
	
 }
 
}
