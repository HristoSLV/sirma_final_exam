package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "/players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer playerNumber;
    private String position;
    private String fullName;
    private Long teamId;

    public PlayerEntity(Integer playerNumber, String position, String fullName, Long teamId) {
        this.playerNumber = playerNumber;
        this.position = position;
        this.fullName = fullName;
        this.teamId = teamId;
    }
}
