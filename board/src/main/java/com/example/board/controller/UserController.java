package com.example.board.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.dto.SignupDto;
import com.example.board.service.UserService;

@RestController
public class UserController {

	final private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public void createUser (@RequestBody SignupDto signupDto) {
		userService.createUser(signupDto);
	}
	
}
