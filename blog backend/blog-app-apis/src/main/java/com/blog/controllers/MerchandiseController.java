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
import com.blog.payloads.MerchandiseDTO;
import com.blog.services.MerchandiseService;

@RestController
@RequestMapping("/merchandise")
public class MerchandiseController {
	
	@Autowired
	private MerchandiseService merchandiseservice;
	
	@PostMapping(value = "/{categoryId}/createMerchandise")
	public ResponseEntity<MerchandiseDTO> createMerchandise(@RequestBody MerchandiseDTO merchandisedto,
			@PathVariable Integer categoryId){
	MerchandiseDTO merch = merchandiseservice.createMerchandise(merchandisedto, categoryId);
	return new ResponseEntity<MerchandiseDTO>(merch,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{categoryId}/updateMerchandise/{merchandiseId}")
	public ResponseEntity<MerchandiseDTO> updateMerchandise(@RequestBody MerchandiseDTO merchandisedto,
			@PathVariable Integer categoryId, @PathVariable Integer merchandiseId){
	MerchandiseDTO merch = merchandiseservice.updateMerchandise(merchandisedto, categoryId,merchandiseId);
	return new ResponseEntity<MerchandiseDTO>(merch,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value="{categoryId}/delete/{merchandiseId}")
	public ResponseEntity<ApiResponse> deleteMerchandise(@PathVariable Integer categoryId, @PathVariable Integer merchandiseId){
	merchandiseservice.deleteMerchandise(categoryId,merchandiseId);
	return new ResponseEntity<ApiResponse>(new ApiResponse("Merchandise has been successfully deleted",true),HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/category/{categoryId}")
	public ResponseEntity<List<MerchandiseDTO>> getMerchandiseByCategory(@PathVariable Integer categoryId){
	List<MerchandiseDTO> merch = merchandiseservice.getMerchandiseByCategory(categoryId);
	return new ResponseEntity<List<MerchandiseDTO>>(merch,HttpStatus.OK);
	}
	
	@GetMapping(value = "/searchMerchandise/{search}")
	public ResponseEntity<List<MerchandiseDTO>> searchMerchandise(@PathVariable("search") String search){
		List<MerchandiseDTO> merch = merchandiseservice.searchMerchandiseByname(search);
		return new ResponseEntity<List<MerchandiseDTO>>(merch, HttpStatus.OK);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<MerchandiseDTO>> allMerchandise(){
	List<MerchandiseDTO> merch = merchandiseservice.getAllMerchandise();
	return new ResponseEntity<List<MerchandiseDTO>>(merch,HttpStatus.OK);
	}
}
