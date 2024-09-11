package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Entity
@Data
@Table(name = "records")
public class RecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Min(value = 1, message = "Minimum value is 1")
    private Long playerId;
    @Min(value = 1, message = "Minimum value is 1")
    private Long matchId;
    @Min(value = 0, message = "Minimum value is 0")
    @Max(value = 90, message = "Maximum value is 90")
    private Integer fromMinutes;
    @Min(value = 0, message = "Minimum value is 0")
    @Max(value = 90, message = "Maximum value is 90")
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
