package com.advisornetwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Booking {
	@Id
	private Long bookingId;
	private String bookingTime;
}
