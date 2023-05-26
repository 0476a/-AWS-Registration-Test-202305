package com.exam.registration.Repository;

import org.apache.ibatis.annotations.Mapper;

import com.exam.registration.Dto.User;

@Mapper
public interface UserRegistrationRepository {
	public int saveUser(User user);
}
