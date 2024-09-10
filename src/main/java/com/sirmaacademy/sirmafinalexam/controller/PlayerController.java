package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.model.MatchEntity;
import com.sirmaacademy.sirmafinalexam.model.PlayerEntity;
import com.sirmaacademy.sirmafinalexam.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/get-all")
    public List<PlayerEntity> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PlayerEntity> getPlayerById(@PathVariable Long id) {
        Optional<PlayerEntity> playerEntity = playerService.getPlayerById(id);
        return playerEntity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<PlayerEntity> addNewPlayer(@RequestBody @Valid PlayerEntity playerEntity) {
        try {
            PlayerEntity player = playerService.addNewPlayer(playerEntity);
            return ResponseEntity.ok(player);
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid data: Data does not match Entity Model");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Successfully deleted the Player!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PlayerEntity> updatePlayer(@PathVariable Long id, @RequestBody @Valid PlayerEntity playerEntity) {
        try {
            PlayerEntity updatedPlayer = playerService.updatePlayer(id, playerEntity);
            return ResponseEntity.ok(updatedPlayer);
        } catch (RuntimeException e) {
            throw new RuntimeException("Invalid data: Data does not match Entity Model");
        }
    }
}
