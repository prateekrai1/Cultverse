package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.Category;
import com.blog.entities.ItemsEntity;
import com.blog.entities.MerchandiseEntity;

public interface ItemsRepo extends JpaRepository<ItemsEntity, Integer> {
	
	List<ItemsEntity> findByCategory(Category category);
	List<ItemsEntity> findByMerchandise(MerchandiseEntity merchandise);
}
