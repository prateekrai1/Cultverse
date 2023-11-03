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
import com.blog.payloads.ItemsDTO;
import com.blog.services.ItemsService;

@RestController
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemservice;
	
	@PostMapping("category/{categoryId}/merchandise/{merchandiseId}/createItem")
	public ResponseEntity<ItemsDTO> createItem(@RequestBody ItemsDTO itemdto,
			@PathVariable Integer categoryId,
			@PathVariable Integer merchandiseId){
		ItemsDTO item = itemservice.createItem(itemdto, categoryId, merchandiseId);
		return new ResponseEntity<ItemsDTO>(item, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateItem/{itemId}")
	public ResponseEntity<ItemsDTO> updateItem(@RequestBody ItemsDTO itemdto,
			@PathVariable Integer itemId){
		ItemsDTO item = itemservice.updateItem(itemdto, itemId);
		return new ResponseEntity<ItemsDTO>(item, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{itemId}")
	public ResponseEntity<ApiResponse> deleteItem(@PathVariable Integer itemId){
		itemservice.deleteItem(itemId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Item has been deleted successfully",true), HttpStatus.OK);
	}
	
	@GetMapping("/category/{categoryId}/items")
	public ResponseEntity<List<ItemsDTO>> itemsByCategory(@PathVariable Integer categoryId){
		List<ItemsDTO> items = itemservice.getItembyCategory(categoryId);
		return new ResponseEntity<List<ItemsDTO>>(items,HttpStatus.OK);
	}
	@GetMapping("/merchandise/{merchandiseId}/items")
	public ResponseEntity<List<ItemsDTO>> itemsByMerchandise(@PathVariable Integer merchandiseId){
		List<ItemsDTO>items = itemservice.getItembyMerchandise(merchandiseId);
		return new ResponseEntity<List<ItemsDTO>>(items, HttpStatus.OK);
	}
	
	@GetMapping("")
	public ResponseEntity<List<ItemsDTO>> allItems(){
		List<ItemsDTO> items = itemservice.getAllItems();
		return new ResponseEntity<List<ItemsDTO>>(items, HttpStatus.OK);
	}
	
	@GetMapping("/{search}")
	public ResponseEntity<List<ItemsDTO>> itemsBySearch(@PathVariable String search){
		List<ItemsDTO> items = itemservice.searchItem(search);
		return new ResponseEntity<List<ItemsDTO>>(items,HttpStatus.OK);
	}
}
