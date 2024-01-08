package com.advisornetwork.service;

import java.util.List;

import com.advisornetwork.model.Advisor;
import com.advisornetwork.model.Booking;
import com.advisornetwork.model.LoginUser;

public interface LoginService {
	public String login(LoginUser loginUser);
	public String assignAdvisor(Long usrId, Long advId);
	public List<Advisor> getAllAdvisorsForUser(Long id);
	public String bookAnAdvisorForUser(Long usrId, Long advId, Booking booking);
	public List<Advisor> getAdvisorBookings(Long usrId);
}
