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
import com.blog.payloads.CategoryDTO;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/categories")


public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	//create
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDto){
		CategoryDTO create = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDTO>(create,HttpStatus.CREATED);
	}
	//update
	@PutMapping("/updateCategory/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDto, @PathVariable Integer catId){
		CategoryDTO update = categoryService.updateCategory(categoryDto,catId);
		return new ResponseEntity<CategoryDTO>(update,HttpStatus.CREATED);
	}
	
	//delete
	@DeleteMapping("/DeleteCategory/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is Deleted successfully", true), HttpStatus.OK);
	}
	//get
	@GetMapping("/categoryById/{catId}")
	public ResponseEntity<CategoryDTO> categoryById(@PathVariable Integer catId){
		CategoryDTO category = categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDTO>(category,HttpStatus.OK);
	}
	
	//get all
	@GetMapping("/allCategories")
	public ResponseEntity<List<CategoryDTO>> allCategories(){
		List<CategoryDTO> catList = categoryService.allCategories();
		return new ResponseEntity<List<CategoryDTO>>(catList, HttpStatus.OK);
	}
}	
