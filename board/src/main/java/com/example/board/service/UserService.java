package com.example.board.service;

import org.springframework.stereotype.Service;

import com.example.board.domain.dto.SignupDto;
import com.example.board.domain.dto.UserDeleteDto;
import com.example.board.domain.dto.UserUpdateDto;
import com.example.board.domain.entity.User;
import com.example.board.repository.UserRepository;

@Service
public class UserService {
	
	//생성자 주입방식
	final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	//create
	public void createUser(SignupDto signupdto) {
		// TODO Auto-generated method stub
		User user = new User();
		
		user.setIdentity(signupdto.getIdentity());
		user.setPassword(signupdto.getPassword());
		user.setName(signupdto.getName());
		user.setPhone(signupdto.getPhone());
		user.setAge(signupdto.getAge());
		
		userRepository.save(user);	
	}
	
	//read
	public SignupDto readUser(String identity) {
		User user = userRepository.findByIdentity(identity);
		
		SignupDto signupdto = new SignupDto();
		signupdto.setIdentity(user.getIdentity());
		signupdto.setPassword(user.getPassword());
		signupdto.setName(user.getName());
		signupdto.setPhone(user.getPhone());
		signupdto.setAge(user.getAge());

		
		return signupdto;
	}
	
	public void updateUser(UserUpdateDto userupdateDto) {
		User user = userRepository.findByIdentity(userupdateDto.getIdentity());
		
		user.setPassword(userupdateDto.getPassword());
		user.setPhone(userupdateDto.getPhone());
		user.setAge(userupdateDto.getAge());
		
		userRepository.save(user);
	}

	public void deleteUser(UserDeleteDto userdeleteDto) {
		User user = userRepository.findByIdentity(userdeleteDto.getIdentity());
		
		userRepository.delete(user);
	}
	
	
	
	
}
