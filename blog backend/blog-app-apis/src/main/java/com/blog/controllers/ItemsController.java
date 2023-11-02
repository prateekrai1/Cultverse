package com.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
