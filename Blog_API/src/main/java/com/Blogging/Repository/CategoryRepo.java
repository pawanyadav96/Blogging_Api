package com.Blogging.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blogging.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
