package com.amar.blogappapis.services.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amar.blogappapis.entities.Category;
import com.amar.blogappapis.entities.Post;
import com.amar.blogappapis.entities.User;
import com.amar.blogappapis.exceptions.ResourceNotFoundException;
import com.amar.blogappapis.payloads.PostDto;
import com.amar.blogappapis.repositories.CategoryRepo;
import com.amar.blogappapis.repositories.PostRepo;
import com.amar.blogappapis.repositories.UserRepo;
import com.amar.blogappapis.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	
	//creating a post
	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		
		
		//here i am taking user and category from URL or setting some values which should not taken by end user
		
		User user= this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "user Id", userId));
		
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category Id", categoryId));
		
		//setting values in DTO
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newpost = this.postRepo.save(post);
		
		return this.modelMapper.map(newpost, PostDto.class );
	}

	
	//updating a post
	@Override
	public Post updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//deleting a post
	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	
	//get all post
	@Override
	public List<PostDto> getAllPost() {
		
		List<Post> posts = this.postRepo.findAll();
		List<PostDto> postdtos = posts.stream().map(post ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postdtos;
	}

	
	//get post by post id
	@Override
	public PostDto getPostById(Integer postId) {

	 Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	
	//get post by category id
	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {

		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		
		List<PostDto> postdtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return postdtos;
	}

	
	//get post by user id 
	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user id ", userId));
		List<Post> posts =this.postRepo.findByUser(user);
		
		List<PostDto> postdtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postdtos;
		
	}
	
	
	//get post by a search 
	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
