package com.example.re_board.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.re_board.domain.dto.GetUserDto;
import com.example.re_board.domain.dto.SignUpDto;
import com.example.re_board.domain.dto.UserDeleteDto;
import com.example.re_board.domain.dto.UserUpdateDto;
import com.example.re_board.service.UserService;

@RestController
public class UserController {

	final UserService userService;
	
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public void createUser(@RequestBody SignUpDto signUpDto) {
		userService.createUser(signUpDto);
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public void updateUser(@RequestBody UserUpdateDto userUpdateDto) {
		userService.updateUser(userUpdateDto);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody UserDeleteDto userDeleteDto) {
		userService.deleteUser(userDeleteDto);
	}
	
	@RequestMapping(value = "/readUser/{identity}", method = RequestMethod.GET)
	public GetUserDto readUser(@PathVariable String identity) {
		return userService.readUser(identity);
	}
	
	
}
