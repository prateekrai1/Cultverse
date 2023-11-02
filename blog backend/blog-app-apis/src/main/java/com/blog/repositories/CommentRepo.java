package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.CommentEntity;

public interface CommentRepo extends JpaRepository<CommentEntity, Integer> {
	
	
}	
