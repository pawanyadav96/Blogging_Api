package com.Blogging.Service;

import java.util.List;

import com.Blogging.Entities.Post;
import com.Blogging.Exceptions.CategoryNotFound;
import com.Blogging.Exceptions.PostNotFound;
import com.Blogging.Exceptions.UserNotFound;

public interface PostService {
	
	public Post createPost(Post post,Integer userid,Integer catId) throws UserNotFound;
	
	public Post updatePost(Post post,Integer postId) throws PostNotFound;
	
	public Post deletePost(Integer postId) throws PostNotFound;
	
	public List<Post> getAllPost();
	
	
	public Post getPostByID(Integer id) throws PostNotFound;
	
	public List<Post> getPostByUserId(Integer userid)throws UserNotFound,PostNotFound;
	
	public List<Post> getPostByCategory(Integer catid) throws CategoryNotFound,PostNotFound;
	
	public List<Post> getPostBykeyword(String keyword);
	

}
