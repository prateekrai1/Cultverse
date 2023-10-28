package com.blog.services;

import java.util.List;

import com.blog.entities.PostsEntity;
import com.blog.payloads.PostDTO;
import com.blog.payloads.PostResponse;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface PostsService {

	//create
	PostDTO create(PostDTO postDto, Integer userId, Integer categoryId) throws Throwable;
	
	//update
	PostDTO updatePost(PostDTO posDto, Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get Single post
	PostDTO getPostById(Integer postId);
	
	//get all post
	PostResponse allPosts(Integer pagenumber, Integer pagesize, String sortBy, String sortDir);
	
	//get All post by category
	List<PostDTO> getPostsbyCategory(Integer categoryId);
	
	//get All post by user
	List<PostDTO> getPostsbyUser(Integer userId) throws Throwable;
	
	List<PostDTO> searchPosts(String keyword);
}
