package ru.otus.spring.FinancialDistribution.services;

import ru.otus.spring.FinancialDistribution.models.ExchangeRate;
import ru.otus.spring.FinancialDistribution.services.pojo.DailyCurrencyInfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CurrencyExchangeServices {
    DailyCurrencyInfo getDailyCurrencyInfo();

    Map<String, Double> getListRatesFromParserDailyCurrencyInfo(DailyCurrencyInfo info) throws IOException;

    void saveRatesCurrencies(Map<String, Double> rates);

    List<ExchangeRate> getListExchangeRate();
}
