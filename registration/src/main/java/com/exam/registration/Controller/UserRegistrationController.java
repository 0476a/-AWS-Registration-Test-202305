package com.exam.registration.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.registration.Dto.UserRegisterRequestDto;
import com.exam.registration.Service.UserRegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserRegistrationController {
	
	private final UserRegistrationService registrationService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody UserRegisterRequestDto userRegisterRequestDto) {
		int result = registrationService.registUser(userRegisterRequestDto);
		
		if(result == 0) {
			return ResponseEntity.badRequest().body("data: " + result);
		}
		return ResponseEntity.ok("data: " + result);
		
	}
}
