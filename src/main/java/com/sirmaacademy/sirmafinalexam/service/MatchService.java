package com.sirmaacademy.sirmafinalexam.service;

import com.sirmaacademy.sirmafinalexam.model.MatchEntity;
import com.sirmaacademy.sirmafinalexam.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchEntity> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<MatchEntity> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public MatchEntity addMatch(MatchEntity matchEntity) {
        return matchRepository.save(matchEntity);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    public MatchEntity updateMatch(Long id, MatchEntity matchEntity) {
        Optional<MatchEntity> existingMatch = matchRepository.findById(id);
        if (existingMatch.isPresent()) {
            MatchEntity newMatch = existingMatch.get();
            newMatch.setFirstTeamId(matchEntity.getFirstTeamId());
            newMatch.setSecondTeamId(matchEntity.getSecondTeamId());
            newMatch.setDate(matchEntity.getDate());
            newMatch.setScore(matchEntity.getScore());
            return matchRepository.save(newMatch);
        } else {
            throw new RuntimeException("Match not found");
        }
    }

}
