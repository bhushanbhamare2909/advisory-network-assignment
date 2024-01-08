package com.advisornetwork.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ANUser {
	@Id
	private Long id;
	private String name;
	private String email;
	private String pwd;
	private List<Long> advisorIds;
}
