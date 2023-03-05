package com.Blogging.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blogging.Entities.Category;
import com.Blogging.Entities.Post;
import com.Blogging.Entities.User;
import com.Blogging.Exceptions.CategoryNotFound;
import com.Blogging.Exceptions.PostNotFound;
import com.Blogging.Exceptions.UserNotFound;
import com.Blogging.Repository.CategoryRepo;
import com.Blogging.Repository.PostRepo;
import com.Blogging.Repository.UserRepo;
import com.Blogging.Service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	public PostRepo prepo;
	@Autowired
	public CategoryRepo crepo;
	@Autowired
	public UserRepo urepo;
	
	
	@Override
	public Post createPost(Post post,Integer userid,Integer catid) throws UserNotFound 
	{
	    Optional<User> user=urepo.findById(userid);
	    Optional<Category> category=crepo.findById(catid);
		
	    if(user.isPresent())
	    {
	    	User users=user.get();
	    	
	    	Category cts=category.get();
	    	Post pot=new Post();
	    	pot.setCategory(cts);
	    	pot.setUser(users);
	    	pot.setDate( new Date());
	    	pot.setImagename("default.png");
	    	pot.setTitle(post.getTitle());
	    	pot.setContent(post.getContent());
	    	Post p=prepo.save(pot);
			return p;
	    }
	    else
	    {
	    	throw new UserNotFound("no user found with this id ,so no post registered yet");
	    }
		
	}


	@Override
	public Post updatePost(Post post, Integer postId) throws PostNotFound {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Post deletePost(Integer postId) throws PostNotFound {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Post getPostByID(Integer id) throws PostNotFound {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> getPostByUserId(Integer userid) throws UserNotFound, PostNotFound {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> getPostByCategory(Integer catid) throws CategoryNotFound, PostNotFound {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Post> getPostBykeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
