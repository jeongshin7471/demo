package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User registUser(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		String newPw = bCryptPasswordEncoder.encode(userDto.getPassword());
		user.setPassword(newPw);
		user.setName(userDto.getName());
		if(userDto.getUsername().equals("admin")) {
			user.setRole("ROLE_ADMIN");
		}else {
			user.setRole("ROLE_MEMBER");
		}
		
		return userRepository.save(user);
	}
}
