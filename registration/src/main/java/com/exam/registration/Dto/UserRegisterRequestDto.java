package com.exam.registration.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRegisterRequestDto {
	private String username;
	private String password;
	private String email;
	private String name;
	
	public User toEntity() {
		return User
				.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}
