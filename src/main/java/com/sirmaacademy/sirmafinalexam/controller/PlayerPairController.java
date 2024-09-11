package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.model.PlayerPairWithTime;
import com.sirmaacademy.sirmafinalexam.service.PlayerPairService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player-pair")
public class PlayerPairController {

    private final PlayerPairService playerPairService;

    public PlayerPairController(PlayerPairService playerPairService) {
        this.playerPairService = playerPairService;
    }

    @GetMapping
    public List<PlayerPairWithTime> getPlayerPairWithBiggestOverlap() {
        return playerPairService.playerPair();
    }
}
