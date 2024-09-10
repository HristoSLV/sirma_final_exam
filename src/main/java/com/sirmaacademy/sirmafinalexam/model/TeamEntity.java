package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "teams")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String teamName;
    private String managerName;
    private String teamGroup;

    public TeamEntity(String teamName, String managerName, String teamGroup) {
        this.teamName = teamName;
        this.managerName = managerName;
        this.teamGroup = teamGroup;
    }
}
