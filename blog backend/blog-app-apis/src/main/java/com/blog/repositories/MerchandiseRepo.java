package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entities.MerchandiseEntity;

public interface MerchandiseRepo extends JpaRepository<MerchandiseEntity, Integer>{
	
}
