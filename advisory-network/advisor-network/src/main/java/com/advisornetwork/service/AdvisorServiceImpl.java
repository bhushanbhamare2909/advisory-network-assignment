package com.advisornetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.advisornetwork.model.Advisor;
import com.advisornetwork.repository.AdvisoryRepository;

@Service
public class AdvisorServiceImpl implements AdvisorService {

	@Autowired
	AdvisoryRepository advisoryRepo;

	@Override
	public String addAdvisor(Advisor advisor) {
		validateRequest(advisor);
		advisoryRepo.save(advisor);
		return "SUCCESS";
	}

	@Override
	public List<Advisor> getAllAdvisors() {
		return advisoryRepo.findAll();
	}

	private static void validateRequest(Advisor advisor) {
		if ((advisor.getName()==null || advisor.getName().isEmpty()) || (advisor.getPhotoUrl() == null || advisor.getPhotoUrl().isEmpty()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
	}

}
