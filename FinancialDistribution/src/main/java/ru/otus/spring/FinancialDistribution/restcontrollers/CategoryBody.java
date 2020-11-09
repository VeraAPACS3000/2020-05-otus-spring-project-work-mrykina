package ru.otus.spring.FinancialDistribution.restcontrollers;

public class CategoryBody {

    private final Long id;
    private final String name;
    private final Double balance;
    private final Double percent;
    private final String comment;
    private final Double purposeAmount;
    private int active;

    public CategoryBody(Long id, String name, Double balance, Double percent, String comment, Double purposeAmount, int active) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.percent = percent;
        this.comment = comment;
        this.purposeAmount = purposeAmount;
        this.active = active;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getPercent() {
        return percent;
    }

    public Double getPurposeAmount() {
        return purposeAmount;
    }

    public String getComment() {
        return comment;
    }

    public int getActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}

