package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemsDTO {
	
	private Integer item_id;
	private String name;
	private Integer quantity;
	private Integer price;
	private CategoryDTO category;
	private MerchandiseDTO merchandise;
	
}	
