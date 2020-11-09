package ru.otus.spring.FinancialDistribution.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@ConfigurationProperties(prefix = "application")
public class PropsSettings {
    private String url;
    private List<String> currencies;

    public void setListCurrencies(String... currencies) {
        this.currencies = Arrays.asList(currencies);
    }

    public List<String> getListCurrencies() {
        return currencies;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
