package com.sirmaacademy.sirmafinalexam.repository;

import com.sirmaacademy.sirmafinalexam.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
