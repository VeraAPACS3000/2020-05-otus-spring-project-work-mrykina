package ru.otus.spring.FinancialDistribution.restcontrollers.dto;

import ru.otus.spring.FinancialDistribution.models.Expense;

import java.time.LocalDate;

public class ExpenseDto {
    private long id;
    private long idCategory;
    private Double amount;
    private LocalDate date;

    public ExpenseDto(long id, long idCategory, Double amount, LocalDate date) {
        this.id = id;
        this.idCategory = idCategory;
        this.amount = amount;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public static ExpenseDto toDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getIdCategory(),
                expense.getAmount(),
                expense.getDate()
        );
    }

    public static Expense toExpense(ExpenseDto expenseDto) {
        return new Expense(
                expenseDto.getId(),
                expenseDto.getIdCategory(),
                expenseDto.getAmount(),
                expenseDto.getDate()
        );
    }
}
