package com.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "Categories")
@NoArgsConstructor

public class Category {
	
	@Id
	@GeneratedValue
	
	private Integer categoryId;
	@Column(name="Category_title", nullable = false, length = 100)
	private String categoryTitle;
	@Column(name="category_desc", nullable = false, length = 100)
	private String  categoryDesc;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PostsEntity> posts = new ArrayList<>();
}
