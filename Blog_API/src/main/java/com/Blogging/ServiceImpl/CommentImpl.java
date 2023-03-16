package com.Blogging.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blogging.Entities.Comment;
import com.Blogging.Entities.Post;
import com.Blogging.Exceptions.CommentNotFound;
import com.Blogging.Exceptions.PostNotFound;
import com.Blogging.Repository.CommentRepo;
import com.Blogging.Repository.PostRepo;
import com.Blogging.Service.CommentService;

@Service
public class CommentImpl implements CommentService{

	@Autowired
	 public PostRepo prepo;
	
	@Autowired
	 public CommentRepo crepo;
	
	@Override
	public Comment createComment(Comment comment, Integer postId) throws PostNotFound{
		 Optional<Post> post=prepo.findById(postId);
		  if(post.isPresent()) 
		  {
			 Post p= post.get();
			 
			 comment.setPost(p);
			p.getComments().add(comment);
			 Comment cmt=crepo.save(comment);
			 prepo.save(p);
			 return cmt;
			 
		  }
		  else
		  {
			  throw new PostNotFound("no post registered with this id");
		  }
		 
		
	}

	@Override
	public Comment deleteComment(Integer commentId) throws CommentNotFound {
		Optional<Comment> cmt=crepo.findById(commentId);
		if(cmt.isPresent())
		{
			Comment c=cmt.get();
			crepo.delete(c);
			return c;
		}
		else
		{
			throw new CommentNotFound("no comment registered ");
		}
	}

}
