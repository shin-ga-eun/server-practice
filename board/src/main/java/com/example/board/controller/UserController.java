package com.example.board.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.dto.SignupDto;
import com.example.board.domain.dto.UserDeleteDto;
import com.example.board.domain.dto.UserUpdateDto;
import com.example.board.service.UserService;

@RestController
public class UserController {

	final private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value="/usercreate",method=RequestMethod.POST)
	public void createUser (@RequestBody SignupDto signupDto) {
		userService.createUser(signupDto);
	}
	
	@RequestMapping(value="/userread/{identity}", method=RequestMethod.GET)
	public SignupDto readUser(@PathVariable String identity) {
		return userService.readUser(identity);
	}
	
	@RequestMapping(value="/userupdate",method=RequestMethod.POST)
	public void updateUser (@RequestBody UserUpdateDto userupdateDto) {
		userService.updateUser(userupdateDto);
	}
	
	@RequestMapping(value="/userdelete",method=RequestMethod.POST)
	public void deleteUser (@RequestBody UserDeleteDto userdeleteDto) {
		userService.deleteUser(userdeleteDto);
	}
}
