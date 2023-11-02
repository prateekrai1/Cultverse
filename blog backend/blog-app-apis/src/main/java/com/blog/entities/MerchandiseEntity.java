package com.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Merchanise")
@Getter
@Setter
@NoArgsConstructor
public class MerchandiseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer merchandise_id;

	@Column(name="merchandise_Name", nullable = false, length = 100)
	private String merchandiseName;
}
