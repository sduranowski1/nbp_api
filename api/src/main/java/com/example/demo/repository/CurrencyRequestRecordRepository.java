package com.example.demo.repository;

import com.example.demo.entity.CurrencyRequestRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyRequestRecordRepository extends JpaRepository<CurrencyRequestRecord, Long> {
    List<CurrencyRequestRecord> findAll();
}
