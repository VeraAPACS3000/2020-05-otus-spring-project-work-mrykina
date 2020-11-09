package ru.otus.spring.FinancialDistribution.repositories.ExchangeRate;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.spring.FinancialDistribution.models.ExchangeRate;

import java.util.Map;


public class CustomExchangeRateRepositoryJpaImpl implements CustomExchangeRateRepositoryJpa {

    @Autowired
    ExchangeRateRepositoryJpa repository;

    CustomExchangeRateRepositoryJpaImpl(ExchangeRateRepositoryJpa repository){
        this.repository = repository;
    }

    @Override
    public void saveExchangeRate(Map<String, Double> rates) {
        for (Map.Entry<String, Double> rate : rates.entrySet()) {
            ExchangeRate exchangeRate = new ExchangeRate(rate.getKey(), rate.getValue());
            repository.save(exchangeRate);
        }
    }
}
