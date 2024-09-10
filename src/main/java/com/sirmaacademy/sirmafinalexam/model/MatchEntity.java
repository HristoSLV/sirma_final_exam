package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "/matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long firstTeamId;
    private Long secondTeamId;
    private LocalDate date;
    private String score;
    private Integer firstTeamPenaltyKickScore;
    private Integer secondTeamPenaltyKickScore;

    public MatchEntity(Long firstTeamId, Long secondTeamId, LocalDate date, String score, Integer firstTeamPenaltyKickScore, Integer secondTeamPenaltyKickScore) {
        this.firstTeamId = firstTeamId;
        this.secondTeamId = secondTeamId;
        this.date = date;
        this.score = score;
        this.firstTeamPenaltyKickScore = firstTeamPenaltyKickScore;
        this.secondTeamPenaltyKickScore = secondTeamPenaltyKickScore;
    }
}
