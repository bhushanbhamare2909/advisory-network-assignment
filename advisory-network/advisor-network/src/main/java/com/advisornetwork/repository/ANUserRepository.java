package com.advisornetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advisornetwork.model.ANUser;

public interface ANUserRepository extends JpaRepository<ANUser, Long> {

}
