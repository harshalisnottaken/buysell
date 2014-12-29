package com.bs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.domain.User;
import com.bs.repository.UserRepository;

@Service
public class UserRegistrationService {
	
	@Autowired
	private UserRepository userRepository;

	public void registerUser(User user) {
		userRepository.save(user);
	}

}
