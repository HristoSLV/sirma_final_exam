package com.sirmaacademy.sirmafinalexam.util;

import com.sirmaacademy.sirmafinalexam.repository.MatchRepository;
import com.sirmaacademy.sirmafinalexam.repository.PlayerRepository;
import com.sirmaacademy.sirmafinalexam.repository.RecordRepository;
import com.sirmaacademy.sirmafinalexam.repository.TeamRepository;
import com.sirmaacademy.sirmafinalexam.service.CsvImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;
    private MatchRepository matchRepository;
    private RecordRepository recordRepository;
    private CsvImportService csvImportService;

    public DataInitializer(TeamRepository teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository, RecordRepository recordRepository, CsvImportService csvImportService) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.recordRepository = recordRepository;
        this.csvImportService = csvImportService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (teamRepository.findAll().isEmpty()) {
            csvImportService.importTeams();
        }
        if (playerRepository.findAll().isEmpty()) {
            csvImportService.importPlayers();
        }
        if (matchRepository.findAll().isEmpty()) {
            csvImportService.importMatches();
        }
        if (recordRepository.findAll().isEmpty()) {
            csvImportService.importRecords();
        }
    }
}
