package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.service.CsvService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-filler")
public class CsvController {
    private CsvService csvService;

    public CsvController(CsvService csvService) {
        this.csvService = csvService;
    }
}
