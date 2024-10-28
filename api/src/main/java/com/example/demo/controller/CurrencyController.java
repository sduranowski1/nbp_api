package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.CurrencyRequest; // Updated import
import com.example.demo.model.ExchangeRateResponse; // Updated import
import com.example.demo.service.ExchangeRateService; // Import your ExchangeRateService class
import com.example.demo.service.ExchangeRateRecordService; // Import the new service
import com.example.demo.entity.ExchangeRateRecord; // Adjust the package as necessary

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    private final ExchangeRateService exchangeRateService;
    private final ExchangeRateRecordService exchangeRateRecordService; // New service

    @Autowired
    public CurrencyController(ExchangeRateService exchangeRateService, ExchangeRateRecordService exchangeRateRecordService) {
        this.exchangeRateService = exchangeRateService;
        this.exchangeRateRecordService = exchangeRateRecordService; // Initialize the new service
    }

    @PostMapping("/get-current-currency-value-command")
    public ResponseEntity<ExchangeRateResponse> getCurrentCurrencyValue(@RequestBody CurrencyRequest request) {
        ExchangeRateResponse rateResponse = exchangeRateService.getExchangeRate(request);
        return ResponseEntity.ok(rateResponse);
    }

    @GetMapping("/requests")
    public List<ExchangeRateRecord> getAllRequests() {
        return exchangeRateRecordService.getAllExchangeRateRecords(); // Fetch from the new service
    }
}
