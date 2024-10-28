package com.example.demo.repository;

import com.example.demo.entity.ExchangeRateRecord; // Add this import
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRateRecordRepository extends JpaRepository<ExchangeRateRecord, Long> {
}
