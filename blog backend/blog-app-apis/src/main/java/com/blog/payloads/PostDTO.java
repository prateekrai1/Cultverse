package com.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.entities.Category;
import com.blog.entities.CommentEntity;
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
	private Set<CommentDTO> comments = new HashSet<>();
}
