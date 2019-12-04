package com.example.re_board.service;

import org.springframework.stereotype.Service;

import com.example.re_board.domain.dto.GetUserDto;
import com.example.re_board.domain.dto.SignUpDto;
import com.example.re_board.domain.dto.UserDeleteDto;
import com.example.re_board.domain.dto.UserUpdateDto;
import com.example.re_board.domain.entity.User;
import com.example.re_board.repository.UserRepository;

@Service
public class UserService {

	final UserRepository userRepository;
	
	public UserService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void createUser (SignUpDto signUpDto){
		User user = new User();
		
		user.setIdentity(signUpDto.getIdentity());
		user.setPassword(signUpDto.getPassword());
		user.setName(signUpDto.getName());
		user.setAge(signUpDto.getAge());
		user.setPhone(signUpDto.getPhone());
		
		userRepository.save(user);
	}
	
	public void updateUser (UserUpdateDto userUpdateDto) {
		User user = userRepository.findByIdentity(userUpdateDto.getIdentity());
		
		user.setPassword(userUpdateDto.getPassword());
		user.setName(userUpdateDto.getName());
		user.setAge(userUpdateDto.getAge());
		user.setPhone(userUpdateDto.getPhone());
		
		userRepository.save(user);
	}
	
	public void deleteUser (UserDeleteDto userDeleteDto) {
		User user = userRepository.findByIdentity(userDeleteDto.getIdentity());
		
		userRepository.delete(user);
	}
	
	//read
	public GetUserDto readUser (String identity) {
		User user = userRepository.findByIdentity(identity);
		GetUserDto getUser = new GetUserDto();
		
		getUser.setIdentity(user.getIdentity());
		getUser.setPassword(user.getPassword());
		getUser.setName(user.getName());
		
		return getUser;
		
	}
	
	
}
