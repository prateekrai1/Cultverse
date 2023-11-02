package com.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.CommentEntity;
import com.blog.entities.PostsEntity;
import com.blog.entities.UserEntity;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CommentDTO;
import com.blog.payloads.PostDTO;
import com.blog.repositories.CommentRepo;
import com.blog.repositories.PostRepo;
import com.blog.repositories.UserRepo;
import com.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private PostRepo postrepo;
	@Autowired
	private CommentRepo commentrepo;
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public CommentDTO createComment(CommentDTO commentdto,Integer userId, Integer postId) throws Throwable {
		UserEntity user = (UserEntity) this.userrepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("UserEntity", "userId", userId));
		PostsEntity post = postrepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("PostEntity", "postId", postId));
		
		CommentEntity comment = modelmapper.map(commentdto, CommentEntity.class);
		comment.setPost(post);
		comment.setUser(user);
		CommentEntity savedCommentEntity = commentrepo.save(comment);
		return modelmapper.map(savedCommentEntity, CommentDTO.class);
	}

	@Override
	public void deleteComment(Integer CommentId) {
		CommentEntity comment = commentrepo.findById(CommentId).orElseThrow(()-> new ResourceNotFoundException("CommentEntity", "commentId", CommentId));
		commentrepo.delete(comment);
	}

	
}
