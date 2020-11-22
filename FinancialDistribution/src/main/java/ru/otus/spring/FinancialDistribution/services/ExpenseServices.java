package ru.otus.spring.FinancialDistribution.services;

import ru.otus.spring.FinancialDistribution.models.Expense;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.ExpenseDto;

import java.util.List;

public interface ExpenseServices {
    List<Expense> getListAllExpenses();

    List<Expense> getListExpensesCategory(Long idCategory);

    void addExpense(ExpenseDto expense);
}
