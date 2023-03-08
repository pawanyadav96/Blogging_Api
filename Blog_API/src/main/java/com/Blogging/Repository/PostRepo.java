package com.Blogging.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entities.Category;
import com.Blogging.Entities.Post;
import com.Blogging.Entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	public List<User> findByUser(User user);
	
	public List<Category> findByCategory(Category category);
	
	public List<Post> findByTitleContaining(String title);

}
