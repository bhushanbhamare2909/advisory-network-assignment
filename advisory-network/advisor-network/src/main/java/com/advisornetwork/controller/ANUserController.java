package com.advisornetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advisornetwork.model.ANUser;
import com.advisornetwork.service.ANUserService;

@RestController
@RequestMapping("/user")
public class ANUserController {
	
	@Autowired
	ANUserService userService;
	
	@GetMapping("/test")
	public String test() {
		return "SUCCESS";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody ANUser user){
		return userService.registerUser(user);
	}
	
	@GetMapping("/")
	public List<ANUser> getAllUsers(){
		return userService.getAllUsers();
	}
	
}
