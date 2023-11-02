package com.blog.services;

import com.blog.payloads.CommentDTO;

public interface CommentService {
	
	CommentDTO createComment(CommentDTO commentdto, Integer userId, Integer postId) throws Throwable;
	void deleteComment(Integer CommentId);
	
}
