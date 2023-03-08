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
	public Post updatePost(Post post, Integer postId) throws PostNotFound 
	{
		Optional<Post> posts=prepo.findById(postId);
		
		if(posts.isPresent())
		{
			Post p= new Post();
			p.setTitle(post.getTitle());
	    	p.setContent(post.getContent());
	    	p.setImagename(post.getImagename());
	    	prepo.save(p);
	    	return p;
		}
		else
		{
			throw new PostNotFound("No post with this post id");
		}
	}


	@Override
	public Post deletePost(Integer postId) throws PostNotFound {
	Optional<Post> post=prepo.findById(postId);
	
	if(post.isPresent())
	{
		Post postt=post.get();
		 prepo.delete(postt);
		 return postt;
	}
	else
	{
		throw new PostNotFound("No post with this id");
	}
		
	}


	@Override
	public List<Post> getAllPost() {
		List<Post> posts=prepo.findAll();
		return posts;
	}


	@Override
	public Post getPostByID(Integer id) throws PostNotFound {
           Optional<Post> posts=prepo.findById(id);
            if(posts.isPresent())
     {
	Post p=posts.get();
	return p;
     }
	
else
    {
	throw new PostNotFound("No post with this id");
      }
}


	@Override
	public List<Post> getPostByUserId(Integer userid) throws UserNotFound, PostNotFound {
		Optional<User> user=urepo.findById(userid);
		
		if(user.isPresent())
		{
			User u=user.get();
			List<Post> posts=u.getPost();
			
			if(posts!=null)			
			{
				return posts;
			}
			else
			{
				throw  new PostNotFound("no post send by this user");
			}
			
		}
		else
		{
			throw new UserNotFound("No user present with this id");
		}
	}


	@Override
	public List<Post> getPostByCategory(Integer catid) throws CategoryNotFound, PostNotFound {
		Optional<Category> categories=crepo.findById(catid);
		if(categories.isPresent())
		{
			Category ct=categories.get();
			List<Post> posts=ct.getPost();
			
			return posts;
		}
		else
		{
			throw new CategoryNotFound("No category found with this id");
		}
		//return null;
	}


	@Override
	public List<Post> getPostBykeyword(String keyword) {
		
		return null;
	}


	@Override
	public Integer countPostByUser(Integer userId) {
		Optional<User> user=urepo.findById(userId);
		
		List<Post> posts=user.get().getPost();
		return posts.size();
		
			
	}

}
