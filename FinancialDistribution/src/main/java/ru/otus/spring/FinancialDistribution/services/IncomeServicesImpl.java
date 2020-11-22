package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.FinancialDistribution.models.Income;
import ru.otus.spring.FinancialDistribution.repositories.Income.IncomeRepositoryJpa;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.IncomeDto;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServicesImpl implements IncomeServices {

    private final IncomeRepositoryJpa repository;

    IncomeServicesImpl(IncomeRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Income> getListIncomes() {
        return (List<Income>) repository.findAll();
    }

    @Override
    @Transactional
    public List<Income> getListIncomesCategory(Long idCategory) {
        return repository.findByIdCategory(idCategory);
    }

    @Override
    @Transactional
    public void addIncome(IncomeDto income) {
        repository.save(IncomeDto.toIncome(income));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Income> getIncome(Long id){
        return repository.findById(id);
    }
}
