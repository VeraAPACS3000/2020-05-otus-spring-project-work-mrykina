package ru.otus.spring.FinancialDistribution.restcontrollers.dto;

import ru.otus.spring.FinancialDistribution.models.Category;

public class CategoryDto {
    private final Long id;
    private final String name;
    private final Double balance;
    private final Double price;
    private final String comment;
    private final Double purposeAmount;
    private final int status;

    CategoryDto(Long id,
                String name,
                Double balance,
                Double price,
                String comment,
                Double purposeAmount, int status) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.price = price;
        this.comment = comment;
        this.purposeAmount = purposeAmount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getPurposeAmount() {
        return purposeAmount;
    }

    public Double getPrice() {
        return price;
    }

    public int getStatus() {
        return status;
    }

    public static CategoryDto toDto(Category category) {
        System.out.println(category);
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getBalance(),
                category.getPercent(),
                category.getComment(),
                category.getPurposeAmount(),
                category.getActive());
    }
}
