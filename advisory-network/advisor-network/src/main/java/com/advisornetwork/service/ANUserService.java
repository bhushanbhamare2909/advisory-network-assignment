package com.advisornetwork.service;

import java.util.List;

import com.advisornetwork.model.ANUser;

public interface ANUserService {
	public String registerUser(ANUser user);
	public List<ANUser> getAllUsers();
}
