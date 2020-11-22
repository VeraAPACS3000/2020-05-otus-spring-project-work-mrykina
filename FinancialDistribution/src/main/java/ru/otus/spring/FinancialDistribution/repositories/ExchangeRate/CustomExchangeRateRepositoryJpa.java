package ru.otus.spring.FinancialDistribution.repositories.ExchangeRate;

import java.util.Map;

public interface CustomExchangeRateRepositoryJpa {
    void saveExchangeRate(Map<String, Double> rates);
}
