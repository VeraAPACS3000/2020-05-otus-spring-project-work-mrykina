package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.FinancialDistribution.models.Expense;
import ru.otus.spring.FinancialDistribution.repositories.Expense.ExpenseRepositoryJpa;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.ExpenseDto;

import java.util.List;

@Service
public class ExpenseServicesImpl implements ExpenseServices {

    private final ExpenseRepositoryJpa repository;

    ExpenseServicesImpl(ExpenseRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> getListAllExpenses() {
        return (List<Expense>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Expense> getListExpensesCategory(Long idCategory) {
        return repository.findByIdCategory(idCategory);
    }

    @Override
    @Transactional
    public void addExpense(ExpenseDto expense) {
        repository.save(ExpenseDto.toExpense(expense));
    }
}
