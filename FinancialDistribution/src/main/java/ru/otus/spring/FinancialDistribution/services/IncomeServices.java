package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;
import ru.otus.spring.FinancialDistribution.models.Income;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.IncomeDto;

import java.util.List;
import java.util.Optional;

@Service
public interface IncomeServices {
    List<Income> getListIncomes();

    List<Income> getListIncomesCategory(Long idCategory);

    void addIncome(IncomeDto income);

    Optional<Income> getIncome(Long id);
}
