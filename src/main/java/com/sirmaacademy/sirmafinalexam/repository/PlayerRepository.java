package com.sirmaacademy.sirmafinalexam.repository;

import com.sirmaacademy.sirmafinalexam.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
