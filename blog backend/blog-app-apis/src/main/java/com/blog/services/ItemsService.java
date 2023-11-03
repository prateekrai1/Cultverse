package com.blog.services;

import java.util.List;

import com.blog.payloads.ItemsDTO;

public interface ItemsService {
	ItemsDTO createItem(ItemsDTO itemdto, Integer categoryId, Integer merchandiseId);
	ItemsDTO updateItem(ItemsDTO itemdto,Integer itemId);
	void deleteItem(Integer itemId);
	List<ItemsDTO> getItembyCategory(Integer categoryId);
	List<ItemsDTO> getItembyMerchandise(Integer merchandiseId);
	List<ItemsDTO> getAllItems();
	List<ItemsDTO> searchItem(String name);
}
