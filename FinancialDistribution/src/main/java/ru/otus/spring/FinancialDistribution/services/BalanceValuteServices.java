package ru.otus.spring.FinancialDistribution.services;

import ru.otus.spring.FinancialDistribution.models.BalanceValute;
import ru.otus.spring.FinancialDistribution.models.Category;

import java.util.List;

public interface BalanceValuteServices {
    List<BalanceValute> getListAllBalances();

    List<BalanceValute> getListActualBalances();

    List<BalanceValute> convertValutes(List<Category> listCategories);

    void saveConvertedBalances(List<BalanceValute> balances);
}
