package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.entities.ItemsEntity;
import com.blog.entities.MerchandiseEntity;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.ItemsDTO;
import com.blog.repositories.CategoryRepo;
import com.blog.repositories.ItemsRepo;
import com.blog.repositories.MerchandiseRepo;
import com.blog.services.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService{

	@Autowired
	private ItemsRepo itemrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private MerchandiseRepo merchandiseRepo;
	
	@Override
	public ItemsDTO createItem(ItemsDTO itemdto, Integer categoryId, Integer merchandiseId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","categoryId",categoryId));
		MerchandiseEntity merchandise = merchandiseRepo.findById(merchandiseId).orElseThrow(()-> new ResourceNotFoundException("merchandiseEntity","merchandiseId",merchandiseId));
		
		ItemsEntity item = modelmapper.map(itemdto, ItemsEntity.class);
		item.setName(itemdto.getName());
		item.setQuantity(itemdto.getQuantity());
		item.setPrice(itemdto.getPrice());
		item.setCategory(category);
		item.setMerchandise(merchandise);
		ItemsEntity newItem = itemrepo.save(item);
		
		return modelmapper.map(newItem, ItemsDTO.class);
	}

	@Override
	public ItemsDTO updateItem(ItemsDTO itemdto, Integer categoryId, Integer itemId) {
		ItemsEntity item = itemrepo.findById(itemId).orElseThrow(()-> new ResourceNotFoundException("ItemsEntity", "itemId",itemId));
		
		item.setName(itemdto.getName());
		item.setQuantity(itemdto.getQuantity());
		item.setPrice(itemdto.getPrice());
		
		ItemsEntity updatedItem = itemrepo.save(item); 
		
		return modelmapper.map(updatedItem, ItemsDTO.class);
	}

	@Override
	public void deleteItem(Integer itemId) {
		ItemsEntity item = itemrepo.findById(itemId).orElseThrow(()-> new ResourceNotFoundException("ItemsEntity", "itemId", itemId));
		itemrepo.delete(item);
	}

	@Override
	public List<ItemsDTO> getItembyCategory(Integer categoryId) {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<ItemsEntity> itemsByCategory = itemrepo.findByCategory(category);
		return itemsByCategory.stream().map((item)->modelmapper.map(item, ItemsDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<ItemsDTO> getItembyMerchandise(Integer merchandiseId) {
		MerchandiseEntity merchandise = merchandiseRepo.findById(merchandiseId).orElseThrow(()-> new ResourceNotFoundException("MerchandiseEntity", "merchandiseId", merchandiseId));
		List<ItemsEntity> itemsByMerchandise = itemrepo.findByMerchandise(merchandise);
		return itemsByMerchandise.stream().map((item)->modelmapper.map(item, ItemsDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<ItemsDTO> getAllItems() {
		List<ItemsEntity> items = itemrepo.findAll();
		return items.stream().map((item)-> modelmapper.map(item, ItemsDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<ItemsDTO> searchItem() {
		// TODO Auto-generated method stub
		return null;
	}

}
