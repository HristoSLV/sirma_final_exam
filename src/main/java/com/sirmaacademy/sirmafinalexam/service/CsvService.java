package com.sirmaacademy.sirmafinalexam.service;

import com.sirmaacademy.sirmafinalexam.repository.MatchRepository;
import com.sirmaacademy.sirmafinalexam.repository.PlayerRepository;
import com.sirmaacademy.sirmafinalexam.repository.RecordRepository;
import com.sirmaacademy.sirmafinalexam.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class CsvService {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final RecordRepository recordRepository;

    public CsvService(TeamRepository teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository, RecordRepository recordRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.recordRepository = recordRepository;
    }


}
