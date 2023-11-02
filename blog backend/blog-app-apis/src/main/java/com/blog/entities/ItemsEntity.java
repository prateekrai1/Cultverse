package com.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Items")
@Getter
@Setter
@NoArgsConstructor
public class ItemsEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer item_id;
	
	private String name;
	private Integer quantity;
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name="Category_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="Merchandise_id")
	private MerchandiseEntity merchandise;
}
