package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;
	
	public long login(String username, String password) {
		long result = userRepository.countByUsernameAndPassword(username, password);
		
		return result;
	}
}
