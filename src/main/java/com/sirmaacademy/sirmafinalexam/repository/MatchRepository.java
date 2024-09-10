package com.sirmaacademy.sirmafinalexam.repository;

import com.sirmaacademy.sirmafinalexam.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
}
