package com.advisornetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advisornetwork.model.Advisor;
import com.advisornetwork.service.AdvisorService;

@RestController
@RequestMapping("/advisor")
public class AdvisorController {
	
	@Autowired
	AdvisorService advisorService;
	
	@GetMapping("/test")
	public String test() {
		return "SUCCESS";
	}
	
	@PostMapping("/admin/advisor")
	public String addAdvisor(@RequestBody Advisor advisor){
		String response = advisorService.addAdvisor(advisor);
		return response;
	}
	
	@GetMapping("/admin/advisor")
	public List<Advisor> getAllAdvisors(){
		return advisorService.getAllAdvisors();
	}
}
