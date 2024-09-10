package com.sirmaacademy.sirmafinalexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "teams")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(min = 1, max = 64, message = "Size must be between 1 and 64")
    private String teamName;
    @Size(min = 1, max = 64, message = "Size must be between 1 and 64")
    private String managerName;
    @Size(min = 1, max = 64, message = "Size must be between 1 and 64")
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
