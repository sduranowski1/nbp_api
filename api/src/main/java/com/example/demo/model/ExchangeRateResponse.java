package com.example.demo.model; // Adjust the package name as necessary

public class ExchangeRateResponse {
    private double value;

    // Constructor
    public ExchangeRateResponse(double value) {
        this.value = value;
    }

    // Getter for the value
    public double getValue() {
        return value;
    }

    // Optionally, you could also provide a setter if you need to modify the value later
    public void setValue(double value) {
        this.value = value;
    }
}
