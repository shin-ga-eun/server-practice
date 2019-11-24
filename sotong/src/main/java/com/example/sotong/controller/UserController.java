package com.example.sotong.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sotong.dto.SignUpDto;
import com.example.sotong.dto.UserDeleteDto;
import com.example.sotong.dto.UserUpdateDto;
import com.example.sotong.service.UserService;

@RestController
public class UserController {
	final private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public void createUser (@RequestBody SignUpDto signupDto) {
		userService.createUser(signupDto);
	}
	
	@RequestMapping(value="/read/{id}", method=RequestMethod.GET)
	public SignUpDto readUser(@PathVariable String id) {
		return userService.readUser(id);
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void updateUser (@RequestBody UserUpdateDto userupdateDto) {
		userService.updateUser(userupdateDto);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void deleteUser (@RequestBody UserDeleteDto userdeleteDto) {
		userService.deleteUser(userdeleteDto);
	}
}
