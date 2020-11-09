package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.ExchangeRateDto;
import ru.otus.spring.FinancialDistribution.services.CurrencyExchangeServices;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CurrencyExchangeRestController {

    CurrencyExchangeServices services;

    CurrencyExchangeRestController(CurrencyExchangeServices services) {
        this.services = services;
    }

    @GetMapping("/api/currencies/prices")
    public List<ExchangeRateDto> getListExchangeRates() {
        return services.getListExchangeRate().stream().map(ExchangeRateDto::toDto).collect(Collectors.toList());
    }
}
