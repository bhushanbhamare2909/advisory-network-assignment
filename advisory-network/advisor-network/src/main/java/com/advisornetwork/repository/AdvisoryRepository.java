package com.advisornetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advisornetwork.model.Advisor;

public interface AdvisoryRepository extends JpaRepository<Advisor, Long> {

}
