package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "players")
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

    public PlayerEntity() {
    }

    public PlayerEntity(Long id, Integer playerNumber, String position, String fullName, Long teamId) {
        this.id = id;
        this.playerNumber = playerNumber;
        this.position = position;
        this.fullName = fullName;
        this.teamId = teamId;
    }

    public Long getId() {
        return id;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(Integer playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
