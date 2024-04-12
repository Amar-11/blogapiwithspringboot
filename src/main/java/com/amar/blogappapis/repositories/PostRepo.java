package com.amar.blogappapis.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amar.blogappapis.entities.Category;
import com.amar.blogappapis.entities.Post;
import com.amar.blogappapis.entities.User;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>{

	//two custom method 
	
	List<Post> findByUser(User user);
	
	//List<Post> findByCategory(Category category);
	
	Page<Post> findByCategory(Category category , Pageable p); 
	
	List<Post> findByTitleContaining(String title);
	
	
}
