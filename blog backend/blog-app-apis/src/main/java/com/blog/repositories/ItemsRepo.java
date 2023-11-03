package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.entities.Category;
import com.blog.entities.ItemsEntity;
import com.blog.entities.MerchandiseEntity;

public interface ItemsRepo extends JpaRepository<ItemsEntity, Integer> {
	
	List<ItemsEntity> findByCategory(Category category);
	List<ItemsEntity> findByMerchandise(MerchandiseEntity merchandise);
	
	@Query("select i from ItemsEntity i where i.name like :key")
	List<ItemsEntity>findByitemName(@Param("key") String name);
}
