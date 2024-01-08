package com.advisornetwork.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.advisornetwork.model.ANUser;
import com.advisornetwork.model.Advisor;
import com.advisornetwork.model.Booking;
import com.advisornetwork.model.LoginUser;
import com.advisornetwork.repository.ANUserRepository;
import com.advisornetwork.repository.AdvisoryRepository;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	ANUserRepository usrRepo;
	
	@Autowired
	AdvisoryRepository advRepo;
	
	@Override
	public String login(LoginUser loginUser) {
		validateRequest(loginUser);
		List<ANUser> allUsers = usrRepo.findAll();
		
		for(ANUser u : allUsers) {
			if(loginUser.getEmail().equals(u.getEmail()) && loginUser.getPassword().equals(u.getPwd()))
				return "LOGIN_SUCCESS";
			else
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid User");
		}
		return "LOGIN_FAIL";
	}
	
	private static void validateRequest(LoginUser loginUser) {
		if ((loginUser.getEmail() == null || loginUser.getEmail().isEmpty()) || 
				(loginUser.getPassword() == null || loginUser.getPassword().isEmpty()) )
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid request");
	}

	@Override
	public String assignAdvisor(Long usrId, Long advId) {
		
		ANUser usr = usrRepo.findById(usrId).get();
		
		List<Long> existingIds = usr.getAdvisorIds();
		
		if(Objects.nonNull(existingIds))
			existingIds.add(advId);
		else {
			existingIds = new ArrayList<>();
		}
		usr.setAdvisorIds(existingIds);
		usrRepo.save(usr);
		return "SUCCESS";
	}

	@Override
	public List<Advisor> getAllAdvisorsForUser(Long usrId) {
		ANUser usr = usrRepo.findById(usrId).get();
		List<Long> advisorIds = usr.getAdvisorIds();
		
		List<Advisor> advsUnderUsr = new ArrayList<>();
		
		for(Long e : advisorIds) {
			Advisor adv = advRepo.findById(e).get();
			advsUnderUsr.add(adv);
		}
		
		return advsUnderUsr;
	}

	@Override
	public String bookAnAdvisorForUser(Long usrId, Long advId, Booking booking) {
		ANUser usr = usrRepo.findById(usrId).get();
		
		List<Long> existingAdvIds = usr.getAdvisorIds();
		
		Advisor bookAdv = advRepo.findById(advId).get();
		
		List<Booking> bookings = bookAdv.getBookings();
		Booking book = new Booking();
		
		for(Long adv : existingAdvIds) {
			if(advId == adv){
				book.setBookingId(booking.getBookingId());
				book.setBookingTime(booking.getBookingTime());
			}
		}
		bookings.add(book);
		bookAdv.setBookings(bookings);
		
		advRepo.save(bookAdv);
		
		return "SUCCESS";
	}

	@Override
	public List<Advisor> getAdvisorBookings(Long usrId) {
		ANUser usr = usrRepo.findById(usrId).get();
		List<Long> existingAdvIds = usr.getAdvisorIds();
		List<Advisor> allAdvs = advRepo.findAll();
		
		List<Advisor> bookedAdvisors = new ArrayList<>();
		
		List<Advisor> matchedAdvs = new ArrayList<>();
		for(Long adv : existingAdvIds) {
			matchedAdvs = allAdvs.stream().filter(a -> a.getId()==adv).collect(Collectors.toList());
		}
		
		for(Advisor ad : matchedAdvs) {
			if(ad.getId()!=null) {
				bookedAdvisors.add(ad);
			}
		}
		return bookedAdvisors;
	}
	
}
