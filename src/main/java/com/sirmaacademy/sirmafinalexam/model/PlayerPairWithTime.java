package com.sirmaacademy.sirmafinalexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerPairWithTime {
    private Long playerOneId;
    private Long playerTwoId;
    private Long totalOverlappedMinutes;
    //private Map<Long, Integer> recordWithOverlappedTime;
}
