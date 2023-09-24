package com.amar.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amar.blogappapis.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
