package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Category;
import com.blog.entities.PostsEntity;
import com.blog.entities.UserEntity;

public interface PostRepo extends JpaRepository<PostsEntity, Integer> {
	
	List<PostsEntity> findByUser(UserEntity userId);
	List<PostsEntity> findByCategory(Category categoryId);
	List<PostsEntity> findByTitle(String Title);
}
