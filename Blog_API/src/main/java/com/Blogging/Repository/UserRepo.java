package com.Blogging.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
