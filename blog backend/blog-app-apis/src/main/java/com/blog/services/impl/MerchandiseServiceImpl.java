package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.MerchandiseEntity;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.MerchandiseDTO;
import com.blog.repositories.CategoryRepo;
import com.blog.repositories.MerchandiseRepo;
import com.blog.services.MerchandiseService;

@Service
public class MerchandiseServiceImpl implements MerchandiseService{
	
	@Autowired
	private MerchandiseRepo merchandiserepo; 
	
	@Autowired
	private CategoryRepo categoryrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public MerchandiseDTO createMerchandise(MerchandiseDTO merchandiseDto, Integer categoryId) {
		Category category = categoryrepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		MerchandiseEntity mer = modelmapper.map(merchandiseDto, MerchandiseEntity.class);
		mer.setCategory(category);
		MerchandiseEntity addMerch = merchandiserepo.save(mer);
		return modelmapper.map(addMerch, MerchandiseDTO.class);
	}

	@Override
	public MerchandiseDTO updateMerchandise(MerchandiseDTO merchandiseDto,Integer categoryId,Integer merchandiseId) {
		Category category = categoryrepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		MerchandiseEntity merchandise = merchandiserepo.findById(merchandiseId).orElseThrow(()-> new ResourceNotFoundException("MerchandiseEntity", "merchandiseId", merchandiseId));
		
		merchandise.setMerchandiseName(merchandiseDto.getMerchandiseName());
		MerchandiseEntity updatedMerch =  merchandiserepo.save(merchandise);
		
		return modelmapper.map(updatedMerch, MerchandiseDTO.class);
	}

	@Override
	public void deleteMerchandise(Integer categoryId,Integer merchandiseId) {
		MerchandiseEntity merchandise = merchandiserepo.findById(merchandiseId).orElseThrow(()-> new ResourceNotFoundException("MerchandiseEntity", "merchandiseId", merchandiseId));
		merchandiserepo.delete(merchandise);
	}

	@Override
	public List<MerchandiseDTO> getAllMerchandise() {
		List<MerchandiseEntity> merchandiseEntity = merchandiserepo.findAll();
		List<MerchandiseDTO> allMerchandise = merchandiseEntity.stream().map((each)-> modelmapper.map(each,MerchandiseDTO.class))
				.collect(Collectors.toList());
		return allMerchandise;
	}
	
	public  List<MerchandiseDTO> searchMerchandiseByname(String search){
		List<MerchandiseEntity> merchandiseList = merchandiserepo.findByMerchandiseName("%" + search + "%");
		return merchandiseList.stream().map((eachMerchandise)-> modelmapper.map(eachMerchandise, MerchandiseDTO.class))
		.collect(Collectors.toList());
	}
	
	@Override
	public List<MerchandiseDTO> getMerchandiseByCategory(Integer categoryId) {
		Category category = categoryrepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<MerchandiseEntity> merchandiseList = merchandiserepo.findByCategory(category);
		return merchandiseList.stream().map((eachMerchandise)-> modelmapper.map(eachMerchandise, MerchandiseDTO.class)).collect(Collectors.toList());
	}

}
