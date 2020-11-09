package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.otus.spring.FinancialDistribution.configuration.PropsSettings;
import ru.otus.spring.FinancialDistribution.models.ExchangeRate;
import ru.otus.spring.FinancialDistribution.repositories.ExchangeRate.ExchangeRateRepositoryJpa;
import ru.otus.spring.FinancialDistribution.services.pojo.DailyCurrencyInfo;
import ru.otus.spring.FinancialDistribution.services.pojo.Valute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CurrencyExchangeServicesImpl implements CurrencyExchangeServices {

    private final RestTemplateConverter restTemplateConverter;
    private final LoaderResources loaderResources;
    private final ExchangeRateRepositoryJpa repository;
    private final PropsSettings settings;

    public CurrencyExchangeServicesImpl(LoaderResources loaderResources, PropsSettings settings, ExchangeRateRepositoryJpa repository, RestTemplateConverter restTemplateConverter) {
        this.loaderResources = loaderResources;
        this.restTemplateConverter = restTemplateConverter;
        this.repository = repository;
        this.settings = settings;
    }

    @Override
    @Transactional
    public DailyCurrencyInfo getDailyCurrencyInfo() {
        RestTemplate restTemplate = restTemplateConverter.getRestTemplate();
        final String uri = settings.getUrl();
        return restTemplate.getForObject(uri, DailyCurrencyInfo.class);
    }

    @Override
    @Transactional
    public Map<String, Double> getListRatesFromParserDailyCurrencyInfo(DailyCurrencyInfo info) {
        Map<String, Double> resultValutesAndRates = new HashMap<>();
        Map<String, Valute> valutes = info.getValute();
        List<String> listCurrencies = loaderResources.getListStringsFromFile();
        for (Map.Entry<String, Valute> entry : valutes.entrySet()) {
            Valute valute = entry.getValue();
            String codeValute = valute.getCharCode();
            Double valueRate = valute.getValue();
            if (listCurrencies.contains(codeValute)) {
                resultValutesAndRates.put(codeValute, valueRate);
            }
        }

        return resultValutesAndRates;
    }

    @Override
    @Transactional
    public void saveRatesCurrencies(Map<String, Double> rates) {
        repository.saveExchangeRate(rates);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExchangeRate> getListExchangeRate() {
        return (List<ExchangeRate>) repository.findAll();
    }
}
