package com.amar.blogappapis.services;

import java.util.List;

import com.amar.blogappapis.entities.Post;
import com.amar.blogappapis.payloads.PostDto;
import com.amar.blogappapis.payloads.PostResponse;

public interface PostService  {
	
	//create

	PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all post
	//List<PostDto> getAllPost();
	
	//get all post with pagination and sorting
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy);
	
	//get a single post 
	
	PostDto getPostById(Integer postId);
	
	//get all post by category
	
	//List<PostDto> getPostByCategory(Integer categoryId);
	
	//get all post by category with pagination
	PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
	
	//get all posts by user
	
	List<PostDto> getPostByUser(Integer userId);
	
	//search Post
	
	List<PostDto> searchPosts(String keyword);
	
	
	
}
