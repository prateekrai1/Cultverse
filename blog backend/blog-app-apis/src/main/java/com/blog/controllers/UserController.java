package com.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDTO;
import com.blog.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	//POST-Create User
	@PostMapping("/createUser")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){
		UserDTO createUser = userService.createUser(userDto);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	
	//PUT-Update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable()Integer userId){
			UserDTO updatedUser = userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}
	
	//DELETE-Delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable()Integer userId){
		userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted successfully", true), HttpStatus.OK);
	}
	
	//GET- User get
	@GetMapping("/allUsers")
	public ResponseEntity<List<UserDTO>> allUsers(){
		return ResponseEntity.ok(userService.allUsers());
	}
	
	//GET - User get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> userById(@PathVariable() Integer userId){
		return ResponseEntity.ok(userService.getUserById(userId));
	}
	
}
