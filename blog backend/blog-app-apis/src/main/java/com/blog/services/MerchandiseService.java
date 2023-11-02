package com.blog.services;

import java.util.List;

import com.blog.payloads.MerchandiseDTO;

public interface MerchandiseService {
	
	//create
	MerchandiseDTO createMerchandise(MerchandiseDTO merchandiseDto);
	//update
	MerchandiseDTO updateMerchandise(MerchandiseDTO merchandiseDto,Integer merchandiseId);
	//delete
	void deleteMerchandise(Integer merchandiseId);
	//get all merchandise
	List<MerchandiseDTO> getAllMerchandise();

}
