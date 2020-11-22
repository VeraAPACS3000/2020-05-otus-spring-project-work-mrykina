package ru.otus.spring.FinancialDistribution.restcontrollers.dto;

import ru.otus.spring.FinancialDistribution.models.Income;

import java.time.LocalDate;

public class IncomeDto {
    private  long id;
    private  long idCategory;
    private  Double amount;
    private  LocalDate date;


    public IncomeDto(long id, long idCategory, Double amount, LocalDate date) {
        this.id = id;
        this.idCategory = idCategory;
        this.amount = amount;
        this.date = date;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
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

    public static IncomeDto toDto(Income income) {
        System.out.println("123");
        System.out.println(income);
        return new IncomeDto(
                income.getId(),
                income.getIdCategory(),
                income.getAmount(),
                income.getDate()
        );
    }

    public static Income toIncome(IncomeDto incomeDto) {
        return new Income(
                incomeDto.getId(),
                incomeDto.getIdCategory(),
                incomeDto.getAmount(),
                incomeDto.getDate()
        );
    }
}
