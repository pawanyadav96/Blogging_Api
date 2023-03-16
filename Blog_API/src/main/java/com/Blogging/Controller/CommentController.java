package com.Blogging.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blogging.Entities.Comment;
import com.Blogging.Exceptions.CommentNotFound;
import com.Blogging.Exceptions.PostNotFound;
import com.Blogging.Service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class CommentController {
	
	@Autowired
	public CommentService cService;
	
	
	@PostMapping("post/{postId}/comments")
	public ResponseEntity<Comment> createcomment(@Valid @RequestBody Comment comment,@PathVariable Integer postId ) throws PostNotFound{
		
		Comment commt=cService.createComment(comment, postId);
		return new ResponseEntity<Comment>(commt,HttpStatus.CREATED);
	}

	
	@DeleteMapping("deletecomment/{cmtId}")
	public ResponseEntity<Comment> deletecomment(@PathVariable Integer cmtId ) throws CommentNotFound{
		
	Comment cmt=cService.deleteComment(cmtId);
		
				return new ResponseEntity<Comment>(cmt,HttpStatus.OK);
				
	}
}
