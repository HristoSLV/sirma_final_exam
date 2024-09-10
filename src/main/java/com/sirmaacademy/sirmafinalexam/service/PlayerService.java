package com.sirmaacademy.sirmafinalexam.service;

import com.sirmaacademy.sirmafinalexam.model.PlayerEntity;
import com.sirmaacademy.sirmafinalexam.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<PlayerEntity> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public PlayerEntity addNewPlayer(PlayerEntity playerEntity) {
        return playerRepository.save(playerEntity);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public PlayerEntity updatePlayer(Long id, PlayerEntity playerEntity) {
        Optional<PlayerEntity> existingPlayer = playerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            PlayerEntity newPlayer = existingPlayer.get();
            newPlayer.setPlayerNumber(playerEntity.getPlayerNumber());
            newPlayer.setPosition(playerEntity.getPosition());
            newPlayer.setFullName(playerEntity.getFullName());
            newPlayer.setTeamId(playerEntity.getTeamId());
            return playerRepository.save(newPlayer);
        } else {
            throw new RuntimeException("Player not found");
        }
    }
}
