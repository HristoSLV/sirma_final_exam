package com.sirmaacademy.sirmafinalexam.controller;

import com.sirmaacademy.sirmafinalexam.service.CsvImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-filler")
public class CsvController {
    private final CsvImportService csvImportService;

    public CsvController(CsvImportService csvImportService) {
        this.csvImportService = csvImportService;
    }

//    @PostMapping("/teams")
//    public ResponseEntity<String> importOrResetDatabase() {
//        try {
//            csvImportService.fillOrResetDB();
//            return ResponseEntity.ok("Team DB has been reset!");
//        } catch (Exception e) {
//            throw new RuntimeException("Could not reset DB");
//        }
//    }
}
