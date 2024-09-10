package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "records")
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long playerId;
    private Long matchId;
    private Integer fromMinutes;
    private Integer toMinutes;

    public RecordEntity() {
        if (this.toMinutes == null) {
            this.toMinutes = 90;
        }
    }

    public RecordEntity(Long playerId, Long matchId, Integer fromMinutes, Integer toMinutes) {
        this.playerId = playerId;
        this.matchId = matchId;
        this.fromMinutes = fromMinutes;
        if (this.toMinutes == null) {
            this.toMinutes = 90;
        } else {
            this.toMinutes = toMinutes;
        }
    }


}
