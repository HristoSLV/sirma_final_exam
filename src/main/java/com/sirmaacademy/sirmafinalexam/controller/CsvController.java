package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.service.CsvImportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-filler")
public class CsvController {
    private CsvImportService csvImportService;

    public CsvController(CsvImportService csvImportService) {
        this.csvImportService = csvImportService;
    }
}
