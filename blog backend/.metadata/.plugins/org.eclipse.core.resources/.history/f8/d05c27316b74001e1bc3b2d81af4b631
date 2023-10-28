package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.CategoryDTO;
import com.blog.repositories.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelmap;

	@Override
	public CategoryDTO createCategory(CategoryDTO catDto) {
		Category cat = modelmap.map(catDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return modelmap.map(addedCat, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO catDto, Integer catId) {
		Category cat = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", catId));
		cat.setCategoryTitle(catDto.getCategoryTitle());
		cat.setCategoryDesc(catDto.getCategoryDesc());

		Category updaCategory = categoryRepo.save(cat);

		return modelmap.map(updaCategory, CategoryDTO.class);
	}

	@Override
	public void deleteCategory(Integer catId) {
		Category cat = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", catId));
		categoryRepo.delete(cat);
	}

	@Override
	public CategoryDTO getCategory(Integer catId) {
		Category cat = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", catId));
		return modelmap.map(cat, CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> allCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDTO> allList = categories.stream().map((cat) -> modelmap.map(cat, CategoryDTO.class))
				.collect(Collectors.toList());

		return allList;
	}

}
