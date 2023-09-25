package com.amar.blogappapis.services;

import java.util.List;

import com.amar.blogappapis.entities.Post;
import com.amar.blogappapis.payloads.PostDto;

public interface PostService  {
	
	//create

	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//update
	
	Post updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all post
	List<PostDto> getAllPost();
	
	//get a single post 
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all posts by user
	
	List<PostDto> getPostByUser(Integer userId);
	
	//search Post
	
	List<Post> searchPosts(String keyword);
	
	
	
}
