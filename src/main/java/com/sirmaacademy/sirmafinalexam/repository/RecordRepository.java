package com.sirmaacademy.sirmafinalexam.repository;

import com.sirmaacademy.sirmafinalexam.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
