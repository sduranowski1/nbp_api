package com.example.demo.service;

import com.example.demo.model.CurrencyRequest;
import com.example.demo.model.ExchangeRateResponse;
import com.example.demo.entity.ExchangeRateRecord;
import com.example.demo.exception.CurrencyNotFoundException;
import com.example.demo.repository.ExchangeRateRecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeRateService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ExchangeRateRecordRepository repository;

    public ExchangeRateService(ExchangeRateRecordRepository repository) {
        this.repository = repository;
    }

    public ExchangeRateResponse getExchangeRate(CurrencyRequest request) {
        try {
            String url = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
            List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
            var currencyRate = findCurrencyRate(response, request.getCurrency());

            // Save the request data to the database
            ExchangeRateRecord record = new ExchangeRateRecord();
            record.setCurrency(request.getCurrency());
            record.setRequesterName(request.getName());
            record.setRate(currencyRate);
            record.setRequestDate(LocalDateTime.now());
            repository.save(record);

            return new ExchangeRateResponse(currencyRate);
        } catch (HttpClientErrorException e) {
            throw new CurrencyNotFoundException("Currency not found: " + request.getCurrency());
        }
    }

    private double findCurrencyRate(List<Map<String, Object>> response, String currencyCode) {
        for (Map<String, Object> currencyData : response) {
            List<Map<String, Object>> rates = (List<Map<String, Object>>) currencyData.get("rates");
            for (Map<String, Object> rateData : rates) {
                if (rateData.get("code").equals(currencyCode)) {
                    return (double) rateData.get("mid"); // Replace with the appropriate field
                }
            }
        }
        throw new CurrencyNotFoundException("Currency not found: " + currencyCode);
    }
}
