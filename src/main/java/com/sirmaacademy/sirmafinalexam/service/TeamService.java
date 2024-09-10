package com.sirmaacademy.sirmafinalexam.service;

import com.sirmaacademy.sirmafinalexam.model.TeamEntity;
import com.sirmaacademy.sirmafinalexam.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamEntity> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<TeamEntity> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public TeamEntity addNewTeam(TeamEntity teamEntity) {
        return teamRepository.save(teamEntity);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }

    public TeamEntity updateTeam(Long id, TeamEntity teamEntity) {
        Optional<TeamEntity> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            TeamEntity newTeam = existingTeam.get();
            newTeam.setTeamName(teamEntity.getTeamName());
            newTeam.setManagerName(teamEntity.getManagerName());
            newTeam.setTeamGroup(teamEntity.getTeamGroup());
            return teamRepository.save(newTeam);
        } else {
            throw new RuntimeException("Team not found");
        }
    }
}
