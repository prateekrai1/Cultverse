package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.CommentEntity;
import com.blog.payloads.ApiResponse;
import com.blog.payloads.CommentDTO;
import com.blog.services.CommentService;


@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentservice;
	
	
	@PostMapping("{userId}/post/{postId}/comments")
	public ResponseEntity<CommentDTO>createComment(@RequestBody CommentDTO comment, @PathVariable Integer postId, @PathVariable Integer userId ) throws Throwable{
		
		CommentDTO createComment = commentservice.createComment(comment,userId, postId);
		return new ResponseEntity<CommentDTO>(createComment,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/comments/{commentId}")
	public ResponseEntity<ApiResponse>deleteComment(@PathVariable Integer commentId ){
		
		commentservice.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment has been deleted successfuly", true),HttpStatus.CREATED);
	}
	
}
