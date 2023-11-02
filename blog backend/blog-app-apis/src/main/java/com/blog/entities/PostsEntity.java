package com.blog.entities;
import java.util.*;

import org.hibernate.annotations.ManyToAny;

import com.blog.payloads.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
public class PostsEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer postId;
		
		@Column(name="post_title", length = 100, nullable = false)
		private String title;
		
		@Column(name="content", length = 10000, nullable = false)
		private String content;
		
		private String imageName;
		
		private Date uploadDate;
		
		@ManyToOne
		@JoinColumn(name="Category_id")
		private Category category;
		@ManyToOne
		private UserEntity user; 
		
		@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
		private Set<CommentEntity> comments = new HashSet<>();
}
