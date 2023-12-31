package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.entities.Category;
import com.blog.entities.PostsEntity;
import com.blog.entities.UserEntity;

public interface PostRepo extends JpaRepository<PostsEntity, Integer> {
	
	List<PostsEntity> findByUser(UserEntity userId);
	List<PostsEntity> findByCategory(Category categoryId);
	
	@Query("select p from PostsEntity p where p.title like :key")
	List<PostsEntity> findByTitle(@Param("key") String title);
}
