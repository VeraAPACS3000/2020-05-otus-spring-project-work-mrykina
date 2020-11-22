package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.FinancialDistribution.models.BalanceValute;
import ru.otus.spring.FinancialDistribution.models.Category;
import ru.otus.spring.FinancialDistribution.models.ExchangeRate;
import ru.otus.spring.FinancialDistribution.repositories.BalanceValute.BalanceValuteRepositoryJpa;
import ru.otus.spring.FinancialDistribution.repositories.ExchangeRate.ExchangeRateRepositoryJpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BalanceValuteServicesImpl implements BalanceValuteServices {

    private final BalanceValuteRepositoryJpa repository;
    private final ExchangeRateRepositoryJpa repositoryExchangeRates;

    BalanceValuteServicesImpl(BalanceValuteRepositoryJpa repository, ExchangeRateRepositoryJpa repositoryExchangeRates) {
        this.repository = repository;
        this.repositoryExchangeRates = repositoryExchangeRates;
    }

    public List<BalanceValute> getListAllBalances() {
        return (List<BalanceValute>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BalanceValute> getListActualBalances() {
        LocalDate localDate = LocalDate.now();
        return (List<BalanceValute>) repository.findByDate(localDate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BalanceValute> convertValutes(List<Category> listCategories) {
        //current date
        Date toDay = new Date();
        //get rates
        List<ExchangeRate> rates = (List<ExchangeRate>) repositoryExchangeRates.findByDate(toDay);
        //prepare
        List<BalanceValute> listBalances = new ArrayList<>();

        //get category
        for (Category category : listCategories) {
            Long idCategory = category.getId();
            Double balance = category.getBalance();

            //get one rate
            for (ExchangeRate rate : rates) {
                Double price = rate.getPrice();
                String codeValute = rate.getName();

                //convert
                Double itogBalance = balance / price;

                //Это ссылочная таблица для отдельной категории с балансами в другой валюте
                BalanceValute balanceValute = new BalanceValute(idCategory, codeValute, itogBalance);
                listBalances.add(balanceValute);
            }
        }
        return listBalances;
    }

    @Override
    @Transactional
    public void saveConvertedBalances(List<BalanceValute> balances) {
        repository.saveAll(balances);
    }
}
