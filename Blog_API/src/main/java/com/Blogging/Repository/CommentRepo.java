package com.Blogging.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
