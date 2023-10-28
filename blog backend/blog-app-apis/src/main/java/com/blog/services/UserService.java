package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payloads.UserDTO;

@Service
public interface UserService {
	
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> allUsers();
	void deleteUser(Integer userId);
}
