package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.blog.entities.CommentEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	
	private int id;
	
	@NotEmpty
	@Size(min = 4, message="Username must be greater than 4 characters")
	private String name;
	
	@Email(message="Email Address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min=6, max=15, message="Password must be longer than 6 characters and no longer than 15 characters")
	private String password;
	
	@NotNull
	private String about;
	
	private Set<CommentDTO> comments = new HashSet<>();

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", about="
				+ about + ", comments=" + comments + "]";
	}

	
}
