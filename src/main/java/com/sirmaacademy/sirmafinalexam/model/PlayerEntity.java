package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "players")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Min(value = 1, message = "Minimum value is 1")
    @Max(value = 400, message = "Maximum value is 400")
    private Integer playerNumber;
    @Size(min = 1, max = 64, message = "Size must be between 1 and 64")
    private String position;
    @Size(min = 1, max = 64, message = "Size must be between 1 and 64")
    private String fullName;
    @Min(value = 1, message = "Minimum value is 1")
    @Max(value = 400, message = "Maximum value is 400")
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
