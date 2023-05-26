package com.exam.registration.Service;

import org.springframework.stereotype.Service;

import com.exam.registration.Dto.User;
import com.exam.registration.Dto.UserRegisterRequestDto;
import com.exam.registration.Repository.UserRegistrationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {
	private final UserRegistrationRepository userRegistrationRepository;
	
	public int registUser(UserRegisterRequestDto userRegisterRequestDto) {
		
		User user = userRegisterRequestDto.toEntity();
		return userRegistrationRepository.saveUser(user);
	}
}
