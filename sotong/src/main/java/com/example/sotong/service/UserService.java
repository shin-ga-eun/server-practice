package com.example.sotong.service;

import org.springframework.stereotype.Service;

import com.example.sotong.dto.SignUpDto;
import com.example.sotong.dto.UserDeleteDto;
import com.example.sotong.dto.UserUpdateDto;
import com.example.sotong.entity.User;
import com.example.sotong.repository.UserRepository;

@Service
public class UserService {
	
	final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	

	public void createUser(SignUpDto signupdto) {
		// TODO Auto-generated method stub
		User user = new User();
		
		user.setId(signupdto.getId());
		user.setPw(signupdto.getPw());
		user.setNickname(signupdto.getNickname());
		
		userRepository.save(user);	
	}
	
	public SignUpDto readUser(String id) {
		User user = userRepository.findById(id);
		
		SignUpDto signupdto = new SignUpDto();
		signupdto.setId(user.getId());
		signupdto.setPw(user.getPw());
		signupdto.setNickname(user.getNickname());
		
		return signupdto;
	}
	
	public void updateUser(UserUpdateDto userupdateDto) {
		User user = userRepository.findById(userupdateDto.getId());
		
		user.setPw(userupdateDto.getPw());
		user.setNickname(userupdateDto.getNickname());
		
		userRepository.save(user);
	}

	public void deleteUser(UserDeleteDto userdeleteDto) {
		User user = userRepository.findById(userdeleteDto.getId());
		
		userRepository.delete(user);
	}
	
	
	
}
