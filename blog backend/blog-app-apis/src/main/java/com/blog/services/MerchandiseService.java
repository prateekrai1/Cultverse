package com.blog.services;

import java.util.List;

import com.blog.payloads.MerchandiseDTO;

public interface MerchandiseService {
	
	//create
	MerchandiseDTO createMerchandise(MerchandiseDTO merchandiseDto, Integer categoryId);
	//update
	MerchandiseDTO updateMerchandise(MerchandiseDTO merchandiseDto,Integer categoryId,Integer merchandiseId);
	//delete
	void deleteMerchandise(Integer categoryId,Integer merchandiseId);
	//get merchandise by category
	List<MerchandiseDTO> getMerchandiseByCategory(Integer categoryId);
	//get merchandise by searching 
	List<MerchandiseDTO> searchMerchandiseByname(String search);
	//get all merchandise
	List<MerchandiseDTO> getAllMerchandise();

}
