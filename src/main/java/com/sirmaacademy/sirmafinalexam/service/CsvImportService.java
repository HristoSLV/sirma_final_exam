package com.sirmaacademy.sirmafinalexam.service;

import com.sirmaacademy.sirmafinalexam.model.MatchEntity;
import com.sirmaacademy.sirmafinalexam.model.PlayerEntity;
import com.sirmaacademy.sirmafinalexam.model.RecordEntity;
import com.sirmaacademy.sirmafinalexam.model.TeamEntity;
import com.sirmaacademy.sirmafinalexam.repository.MatchRepository;
import com.sirmaacademy.sirmafinalexam.repository.PlayerRepository;
import com.sirmaacademy.sirmafinalexam.repository.RecordRepository;
import com.sirmaacademy.sirmafinalexam.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import static com.sirmaacademy.sirmafinalexam.util.DateTimeFormatterUtil.parseDateFromAllFormats;
import static com.sirmaacademy.sirmafinalexam.util.RecordTimeParser.toMinutesParser;

@Service
public class CsvImportService {

    private static final String TEAM_FILE = "./src/main/resources/teams.csv";
    private static final String PLAYER_FILE = "./src/main/resources/players.csv";
    private static final String MATCH_FILE = "./src/main/resources/matches.csv";
    private static final String RECORD_FILE = "./src/main/resources/records.csv";

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final RecordRepository recordRepository;

    public CsvImportService(TeamRepository teamRepository, PlayerRepository playerRepository, MatchRepository matchRepository, RecordRepository recordRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.recordRepository = recordRepository;
    }

    public void importTeams() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TEAM_FILE))) {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                TeamEntity teamEntity = new TeamEntity(
                        fields[1].trim(),
                        fields[2].trim(),
                        fields[3].trim()
                );
                teamRepository.save(teamEntity);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("The TEAM_FILE is null" + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importPlayers() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PLAYER_FILE))) {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                PlayerEntity playerEntity = new PlayerEntity(
                        Integer.parseInt(fields[1].trim()),
                        fields[2].trim(),
                        fields[3].trim(),
                        Long.parseLong(fields[4].trim())
                );
                playerRepository.save(playerEntity);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("The PLAYER_FILE is null" + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importMatches() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MATCH_FILE))) {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");

                MatchEntity matchEntity = new MatchEntity(
                        Long.parseLong(fields[1].trim()),
                        Long.parseLong(fields[2].trim()),
                        parseDateFromAllFormats(fields[3].trim()),
                        fields[4]
                );
                matchRepository.save(matchEntity);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The MATCH_FILE is null" + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void importRecords() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(RECORD_FILE))) {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(",");
                RecordEntity recordEntity = new RecordEntity(
                        Long.parseLong(fields[1].trim()),
                        Long.parseLong(fields[2].trim()),
                        Integer.parseInt(fields[3].trim()),
                        toMinutesParser(fields[4].trim())
                );
                recordRepository.save(recordEntity);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("The RECORD_FILE is null" + e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
