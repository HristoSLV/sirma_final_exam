package com.sirmaacademy.sirmafinalexam.service;

import com.sirmaacademy.sirmafinalexam.model.PlayerEntity;
import com.sirmaacademy.sirmafinalexam.model.PlayerPair;
import com.sirmaacademy.sirmafinalexam.model.PlayerPairWithTime;
import com.sirmaacademy.sirmafinalexam.model.RecordEntity;
import com.sirmaacademy.sirmafinalexam.repository.PlayerRepository;
import com.sirmaacademy.sirmafinalexam.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerPairService {

    private final PlayerRepository playerRepository;
    private final RecordRepository recordRepository;

    public PlayerPairService(PlayerRepository playerRepository, RecordRepository recordRepository) {
        this.playerRepository = playerRepository;
        this.recordRepository = recordRepository;
    }

    public PlayerPairWithTime playerPairWithHighestOverlap() {
        List<PlayerPairWithTime> playerPairWithTimeList = playerPairsWithBiggestOverlapInEachTeam();
        PlayerPairWithTime mostOverlappingPair = new PlayerPairWithTime();
        long biggestOverlapInMinutes = 0;

        for (var playerPair: playerPairWithTimeList) {
            if (playerPair.getTotalOverlappedMinutes() > biggestOverlapInMinutes) {
                mostOverlappingPair.setPlayerOneId(playerPair.getPlayerOneId());
                mostOverlappingPair.setPlayerTwoId(playerPair.getPlayerTwoId());
                mostOverlappingPair.setTotalOverlappedMinutes(playerPair.getTotalOverlappedMinutes());
                biggestOverlapInMinutes = playerPair.getTotalOverlappedMinutes();
            }
        }
        return mostOverlappingPair;
    }

    public List<PlayerPairWithTime> playerPairsWithBiggestOverlapInEachTeam() {
        List<PlayerPairWithTime> playerPairWithTimeList = new ArrayList<>();
        List<RecordEntity> records = recordRepository.findAll();
        List<PlayerEntity> players = playerRepository.findAll();

        Map<Long, List<PlayerEntity>> playerPairsByTeam = players.stream()
                .collect(Collectors.groupingBy(PlayerEntity::getTeamId));

        for (var entry : playerPairsByTeam.entrySet()) {
             List<PlayerEntity> playersInATeam = entry.getValue();

            Set<Long> playerIds = playersInATeam.stream().map(PlayerEntity::getId).collect(Collectors.toSet());
            List<RecordEntity> teamRecords = records.stream()
                    .filter(record -> playerIds.contains(record.getPlayerId())).toList();

            PlayerPairWithTime pairWithHighestOverlap = findPairWithHighestOverlapInTeam(playersInATeam, teamRecords);
            if (pairWithHighestOverlap != null) {
                playerPairWithTimeList.add(pairWithHighestOverlap);
            }

        }
        return playerPairWithTimeList;
    }

    private PlayerPairWithTime findPairWithHighestOverlapInTeam(List<PlayerEntity> playerEntities, List<RecordEntity> recordEntities) {
        Map<PlayerPair, Long> playerPairMap = new HashMap<>();

        Map<Long, List<RecordEntity>> recordsByPlayer = recordEntities.stream()
                .collect(Collectors.groupingBy(RecordEntity::getPlayerId));

        for (int i = 0; i < playerEntities.size(); i++) {
            for (int j = i + 1; j < playerEntities.size(); j++) {
                PlayerEntity playerOne = playerEntities.get(i);
                PlayerEntity playerTwo = playerEntities.get(j);

                List<RecordEntity> recordsOne = recordsByPlayer.getOrDefault(playerOne.getId(), Collections.emptyList());
                List<RecordEntity> recordsTwo = recordsByPlayer.getOrDefault(playerTwo.getId(), Collections.emptyList());

                Long totalOverlappedMinutes = totalOverlappedTimeWithMatches(recordsOne, recordsTwo);

                PlayerPair pair = new PlayerPair(playerOne.getId(), playerTwo.getId());
                playerPairMap.put(pair, totalOverlappedMinutes);
            }
        }

        return playerPairMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(entry -> new PlayerPairWithTime(entry.getKey().getPlayerOneId(), entry.getKey().getPlayerTwoId(),
                        entry.getValue()))
                .orElse(null);
    }

    private Long totalOverlappedTimeWithMatches(List<RecordEntity> recordsPlayerOne, List<RecordEntity> recordsPlayerTwo) {
        long totalOverLappedTime = 0L;

        for (var recordOne : recordsPlayerOne) {
            for (var recordTwo : recordsPlayerTwo) {
                int overlapDuration;
                if (recordTwo.getFromMinutes() > recordOne.getFromMinutes()) {
                    if (recordOne.getToMinutes() > recordTwo.getToMinutes()) {
                        overlapDuration = recordTwo.getToMinutes() - recordTwo.getFromMinutes();
                        totalOverLappedTime += overlapDuration;
                    } else {
                        overlapDuration = recordOne.getToMinutes() - recordTwo.getFromMinutes();
                        totalOverLappedTime += overlapDuration;
                    }
                } else {
                    if (recordOne.getToMinutes() > recordTwo.getToMinutes()) {
                        overlapDuration = recordTwo.getToMinutes() - recordOne.getFromMinutes();
                        totalOverLappedTime += overlapDuration;
                    } else {
                        overlapDuration = recordOne.getToMinutes() - recordOne.getFromMinutes();
                        totalOverLappedTime += overlapDuration;
                    }
                }
            }
        }
        return totalOverLappedTime;
    }

}
