package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long firstTeamId;
    private Long secondTeamId;
    private LocalDate date;
    private String score;
//    private Integer firstTeamPenaltyKickScore;
//    private Integer secondTeamPenaltyKickScore;

    public MatchEntity(Long firstTeamId, Long secondTeamId, LocalDate date, String score) {
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.date = date;
        this.score = score;
    }

    public MatchEntity() {
    }

    public MatchEntity(Long id, Long firstTeamId, Long secondTeamId, LocalDate date, String score) {
        this.id = id;
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.date = date;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getFirstTeamId() {
        return firstTeamId;
    }

    public void setFirstTeamId(Long firstTeamId) {
        this.firstTeamId = firstTeamId;
    }

    public Long getSecondTeamId() {
        return secondTeamId;
    }

    public void setSecondTeamId(Long secondTeamId) {
        this.secondTeamId = secondTeamId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
