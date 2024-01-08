package com.advisornetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.advisornetwork.model.ANUser;
import com.advisornetwork.repository.ANUserRepository;

@Service
public class ANUserServiceImpl implements ANUserService {
	
	@Autowired
	ANUserRepository userRepo;
	
	@Override
	public String registerUser(ANUser user) {
		validateRequest(user);
		userRepo.save(user);
		return "SUCCESS";
	}
	
	private static void validateRequest(ANUser user) {
		if ((user.getName()==null || user.getName().isEmpty()) || 
				(user.getEmail() == null || user.getEmail().isEmpty()) || 
				(user.getPwd() == null || user.getPwd().isEmpty()) )
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
	}

	@Override
	public List<ANUser> getAllUsers() {
		return userRepo.findAll();
	}
}
