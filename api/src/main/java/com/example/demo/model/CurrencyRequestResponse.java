package com.example.demo.dto;

import java.time.LocalDateTime;

public class CurrencyRequestResponse {
    private String currency;
    private String name;
    private LocalDateTime date;
    private Double value;

    // Constructor
    public CurrencyRequestResponse(String currency, String name, LocalDateTime date, Double value) {
        this.currency = currency;
        this.name = name;
        this.date = date;
        this.value = value;
    }

    // Getters
    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getValue() {
        return value;
    }

    // Setters
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
