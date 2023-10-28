package com.blog.payloads;

import java.util.Date;

import com.blog.entities.Category;
import com.blog.entities.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
	
	private Integer postId;
	private String title;
	private String content;
	private String imageName;
	private Date uploadDate;
	private CategoryDTO category;
	private UserDTO user; 
}
