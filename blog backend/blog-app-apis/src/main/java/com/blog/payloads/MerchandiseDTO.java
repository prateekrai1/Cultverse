package com.blog.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MerchandiseDTO {
	
	private Integer merchandise_id;
	private String merchandiseName;
	
}
