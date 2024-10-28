package com.example.demo.service;

import com.example.demo.entity.ExchangeRateRecord;
import com.example.demo.repository.ExchangeRateRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExchangeRateRecordService {

    private final ExchangeRateRecordRepository repository;

    public ExchangeRateRecordService(ExchangeRateRecordRepository repository) {
        this.repository = repository;
    }

    public List<ExchangeRateRecord> getAllExchangeRateRecords() {
        return repository.findAll();
    }
}
