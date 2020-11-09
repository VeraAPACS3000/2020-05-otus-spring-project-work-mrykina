package ru.otus.spring.FinancialDistribution.restcontrollers.dto;

import ru.otus.spring.FinancialDistribution.models.ExchangeRate;

import java.time.LocalDate;

public class ExchangeRateDto {

    private Long id;
    private String name;
    private double price;
    private LocalDate date;

    public ExchangeRateDto(Long id, String name, double price, LocalDate date) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static ExchangeRateDto toDto(ExchangeRate rate) {
        return new ExchangeRateDto(
                rate.getId(),
                rate.getName(),
                rate.getPrice(),
                rate.getDate());
    }
}
