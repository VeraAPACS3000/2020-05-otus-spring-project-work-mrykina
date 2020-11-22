package ru.otus.spring.FinancialDistribution.repositories.ExchangeRate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.spring.FinancialDistribution.models.ExchangeRate;

import java.util.Date;
import java.util.List;

@Repository
public interface ExchangeRateRepositoryJpa extends CrudRepository<ExchangeRate, Long>, CustomExchangeRateRepositoryJpa {
    List<ExchangeRate> findByDate(Date date);
}
