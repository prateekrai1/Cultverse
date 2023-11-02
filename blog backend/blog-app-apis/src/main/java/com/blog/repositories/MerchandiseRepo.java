package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blog.entities.Category;
import com.blog.entities.MerchandiseEntity;

public interface MerchandiseRepo extends JpaRepository<MerchandiseEntity, Integer>{
	
	List<MerchandiseEntity> findByCategory(Category categoryId);
	
	@Query("select m from MerchandiseEntity m where m.merchandiseName like :key")
	List<MerchandiseEntity> findByMerchandiseName(@Param("key") String name);
}
