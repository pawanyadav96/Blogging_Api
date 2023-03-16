package com.Blogging.Service;

import com.Blogging.Entities.Comment;
import com.Blogging.Exceptions.CommentNotFound;
import com.Blogging.Exceptions.PostNotFound;

public interface CommentService {
	
	public Comment createComment(Comment comment,Integer postId) throws PostNotFound;

	void deleteComment(Integer commentId) throws CommentNotFound;
}
