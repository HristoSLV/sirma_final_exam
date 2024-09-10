package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "teams")
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

    public TeamEntity() {
    }

    public TeamEntity(Long id, String teamName, String managerName, String teamGroup) {
        this.id = id;
        this.teamName = teamName;
        this.managerName = managerName;
        this.teamGroup = teamGroup;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }

}
