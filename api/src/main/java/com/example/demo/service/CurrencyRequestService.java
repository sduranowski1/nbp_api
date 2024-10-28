package com.example.demo.service;

import com.example.demo.entity.CurrencyRequestRecord;
import com.example.demo.repository.CurrencyRequestRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyRequestService {

    private final CurrencyRequestRecordRepository repository;

    public CurrencyRequestService(CurrencyRequestRecordRepository repository) {
        this.repository = repository;
    }

    public List<CurrencyRequestRecord> getAllRequests() {
        return repository.findAll();
    }
}
