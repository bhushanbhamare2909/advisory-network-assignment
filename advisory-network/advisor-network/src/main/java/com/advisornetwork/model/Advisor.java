package com.advisornetwork.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
	@Id
	private Long id;
	private String name;
	private String photoUrl;
	
	@ElementCollection
    @CollectionTable(name = "advisor_bookings", joinColumns = @JoinColumn(name = "advisor_id"))
	private List<Booking> bookings;
}
