package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.model.MatchEntity;
import com.sirmaacademy.sirmafinalexam.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/get-all")
    public List<MatchEntity> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MatchEntity> getMatchById(@PathVariable Long id) {
        Optional<MatchEntity> matchEntity = matchService.getMatchById(id);
        return matchEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<MatchEntity> addNewMatch(@RequestBody @Valid MatchEntity matchEntity) {
         MatchEntity match = matchService.addMatch(matchEntity);
         return ResponseEntity.ok(match);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok("Successfully deleted the match!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MatchEntity> updateMatch(@PathVariable Long id, @RequestBody @Valid MatchEntity matchEntity) {
        MatchEntity match = matchService.updateMatch(id, matchEntity);
        return ResponseEntity.ok(match);
    }
}
