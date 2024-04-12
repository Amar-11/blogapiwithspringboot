package com.amar.blogappapis.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amar.blogappapis.payloads.PostDto;
import com.amar.blogappapis.payloads.PostResponse;
import com.amar.blogappapis.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;

	//create
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(
			@Valid @RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		
		PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
		return new ResponseEntity<PostDto>(createPost,HttpStatus.CREATED);
		
	}
	
	
	//get post by user
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		
		List<PostDto> postsByUser = this.postService.getPostByUser(userId);
		
		return new ResponseEntity<List<PostDto>>(postsByUser,HttpStatus.OK);
		
	}
	
	/*
	//get post by category
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
		
		List<PostDto> postsByCategory = this.postService.getPostByCategory(categoryId);
		
		return new ResponseEntity<List<PostDto>>(postsByCategory,HttpStatus.OK);
		
	}
	*/
	
	//get post by category with pagination
	
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<PostResponse> getPostByCategory(@PathVariable Integer categoryId,
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize
			){
		
		 PostResponse postByCategory = this.postService.getPostByCategory(categoryId,pageNumber,pageSize);
		
		return new ResponseEntity<PostResponse>(postByCategory,HttpStatus.OK);
		
	}

	
	//get all posts
	
	/*
	@GetMapping("/all/posts")
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> allPost = this.postService.getAllPost();
		return new ResponseEntity<List<PostDto>>(allPost,HttpStatus.OK);
		
	}
	*/
	
	//get all post with pagination and sorting using field
	@GetMapping("/all/posts")
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize,
			@RequestParam(value = "sortBy",defaultValue = "postId",required = false) String sortBy
			){
		PostResponse allPost = this.postService.getAllPost(pageNumber,pageSize,sortBy);
		return new ResponseEntity<PostResponse>(allPost,HttpStatus.OK);
		
	}
	
	//get one post by ID
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getOnePost(@PathVariable Integer postId){
		PostDto postById = this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postById,HttpStatus.OK);
				
	}
	
	//delete a post
	@DeleteMapping("/post/delete/{postId}")
	public ResponseEntity<?> deletePost( @PathVariable Integer postId){
		
		this.postService.deletePost(postId);
		return new ResponseEntity(Map.of("message", "Post Deleted Successfully"),HttpStatus.OK);
	}
	
	//update a post 
	@PutMapping("/post/update/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		
		PostDto updatePost = this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
	}
	
	
	//search a post 
	@GetMapping("/post/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable("keywords") String keywords){
		List<PostDto> result = this.postService.searchPosts(keywords);
		
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK) ;
		
	}
	
	
	
	
}
