package com.blog.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.blog.entities.*; 


public interface UserRepo<T> extends JpaRepository<UserEntity, Integer>{
	
}
