package com.sirmaacademy.sirmafinalexam.repository;

import com.sirmaacademy.sirmafinalexam.model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
