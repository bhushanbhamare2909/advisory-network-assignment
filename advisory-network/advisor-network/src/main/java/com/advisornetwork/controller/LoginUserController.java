package com.advisornetwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advisornetwork.model.Advisor;
import com.advisornetwork.model.Booking;
import com.advisornetwork.model.LoginUser;
import com.advisornetwork.service.LoginService;

@RestController
@RequestMapping("/user")
public class LoginUserController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public String userLogin(@RequestBody LoginUser userLogin){
		return loginService.login(userLogin);
	}
	
	@PostMapping("/assign-advisor/{usrId}/advisor/{advId}")
	public String assignAdvisorToUser(@PathVariable("usrId") Long usrId, @PathVariable("advId") Long advId) {
		return loginService.assignAdvisor(usrId, advId);
	}
	
	@GetMapping("/{usrId}/advisor")
	public List<Advisor> getAllAdvisorsForUser(@PathVariable("usrId") Long usrId){
		return loginService.getAllAdvisorsForUser(usrId);
	}
	
	@PostMapping("/{usrId}/advisor/{advId}")
	public String bookAnAdvisorForUser(@PathVariable("usrId") Long usrId, @PathVariable("advId") Long advId, @RequestBody Booking booking) {
		return loginService.bookAnAdvisorForUser(usrId, advId, booking);
	}
	
	@GetMapping("{usrId}/advisor/booking/")
	public List<Advisor> getAdvisorBookings(@PathVariable("usrId") Long usrId){
		return loginService.getAdvisorBookings(usrId);
	}
}
