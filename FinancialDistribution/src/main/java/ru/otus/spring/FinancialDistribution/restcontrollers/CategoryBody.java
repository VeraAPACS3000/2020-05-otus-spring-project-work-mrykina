package ru.otus.spring.FinancialDistribution.restcontrollers;

public class CategoryBody {

    private String id;
    private String name;
    private String balance;
    private String percent;
    private String comment;
    private String purposeAmount;
    private String active;

    public CategoryBody() {

    }

    public CategoryBody(String id, String name, String balance, String percent, String comment, String purposeAmount, String active) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.percent = percent;
        this.comment = comment;
        this.purposeAmount = purposeAmount;
        this.active = active;
    }

    public CategoryBody(String name, String balance, String percent, String comment, String purposeAmount, String active) {
        this.name = name;
        this.balance = balance;
        this.percent = percent;
        this.comment = comment;
        this.purposeAmount = purposeAmount;
    }

    public String getBalance() {
        return balance;
    }

    public String getPercent() {
        return percent;
    }

    public String getPurposeAmount() {
        return purposeAmount;
    }

    public String getComment() {
        return comment;
    }

    public String getActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

