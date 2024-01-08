package com.advisornetwork.service;

import java.util.List;

import com.advisornetwork.model.Advisor;

public interface AdvisorService {
	public String addAdvisor(Advisor advisor);
	public List<Advisor> getAllAdvisors();
}
