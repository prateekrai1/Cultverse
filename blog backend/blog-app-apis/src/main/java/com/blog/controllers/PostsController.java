package com.blog.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.multipart.MultipartFile;

import com.blog.config.Constants;
import com.blog.entities.PostsEntity;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.FileResponse;
import com.blog.payloads.PostDTO;
import com.blog.payloads.PostResponse;
//import com.blog.services.FileService;
import com.blog.services.PostsService;

@RestController
@RequestMapping("/posts")
public class PostsController {
	
	@Autowired
	PostsService postservice;
	
//	@Autowired
//	FileService fileservice;
	
	//create
	@PostMapping("/user/{userId}/category/{categoryId}/createposts")
	public ResponseEntity<PostDTO> createPost(
		@RequestBody PostDTO postDto,
		@PathVariable Integer userId,
		@PathVariable Integer categoryId) throws Throwable{
		
		PostDTO createPost = postservice.create(postDto, userId, categoryId);		
		return new ResponseEntity<PostDTO>(createPost,HttpStatus.CREATED);
	}
	
	//get By user
	@GetMapping("/user/{userId}/allPosts")
	public ResponseEntity<List<PostDTO>> getPostByUser(
			@PathVariable Integer userId
			) throws Throwable{
	
			 List<PostDTO>posts = this.postservice.getPostsbyUser(userId);
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
		
	}
	
	//get by category
	@GetMapping("/category/{categoryId}/allPosts")
	public ResponseEntity<List<PostDTO>> getPostByCategory(
			@PathVariable Integer categoryId
			) throws Throwable{
	
		List<PostDTO>posts = this.postservice.getPostsbyCategory(categoryId);
		return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);	
	}
	
	//get all posts
	@GetMapping("/allPosts")
	public ResponseEntity<PostResponse> allPost(
			@RequestParam(value ="pageNumber", defaultValue = Constants.PAGE_NUMBER, required = false)Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = Constants.PAGE_SIZE, required = false)Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = Constants.SORT_BY, required = false)String sortBy,
			@RequestParam(value = "sortDir", defaultValue = Constants.SORT_DIR, required = false)String sortDir)
	{
		
		PostResponse posts = postservice.allPosts(pageNumber,pageSize,sortBy,sortDir);
		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
	}
	
	//post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDTO> postById(@PathVariable Integer postId){
		
		PostDTO post = postservice.getPostById(postId);
		return new ResponseEntity<PostDTO>(post,HttpStatus.OK);
	}
	
	//delete post
	@DeleteMapping("/{postId}")
	public ApiResponse delepost(@PathVariable Integer postId) {
		postservice.deletePost(postId);
		return new ApiResponse("Post is successfully Deleted", true);
	}
	
	//update Post
	@PutMapping("/update/{postId}")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDto, @PathVariable Integer postId){
		PostDTO post = postservice.updatePost(postDto, postId);
		return new ResponseEntity<PostDTO>(post,HttpStatus.OK);
	}
	
	//search
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<PostDTO>> searchByTitle(
			@PathVariable("keywords") String keywords) {
		
		List<PostDTO> search = postservice.searchPosts(keywords);
		return new ResponseEntity<List<PostDTO>>(search,HttpStatus.OK);
	}
	
//	//postImage upload
//	@PostMapping("/image/upload/{postId}")
//	public ResponseEntity<PostDTO> uploadImage(@RequestParam("image")
//	MultipartFile image,
//	@PathVariable Integer postId) throws IOException{
//		
//		String fileName = this.fileservice.uploadImage(path, image);
//		PostDTO postdto =  postservice.getPostById(postId);
//		postdto.setImageName(fileName);
//		PostDTO post = postservice.updatePost(postdto, postId);
//		return new ResponseEntity<PostDTO>(post, HttpStatus.OK);
//	}
}
