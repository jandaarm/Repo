package com.example.as4.repository;

import com.example.as4.model.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
