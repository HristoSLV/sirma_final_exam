package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.model.TeamEntity;
import com.sirmaacademy.sirmafinalexam.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/get-all")
    public List<TeamEntity> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable Long id) {
        Optional<TeamEntity> teamEntity = teamService.getTeamById(id);
        return teamEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<TeamEntity> addNewTeam(@RequestBody TeamEntity teamEntity) {
        TeamEntity team = teamService.addNewTeam(teamEntity);
        return ResponseEntity.ok(team);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.ok("Successfully deleted the Team!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeamEntity> updatePlayer(@PathVariable Long id, @RequestBody TeamEntity teamEntity) {
        TeamEntity updatedTeam = teamService.updateTeam(id, teamEntity);
        return ResponseEntity.ok(updatedTeam);
    }
}
