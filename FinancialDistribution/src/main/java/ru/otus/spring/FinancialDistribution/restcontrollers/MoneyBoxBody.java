package ru.otus.spring.FinancialDistribution.restcontrollers;

public class MoneyBoxBody {
    private int countMonths;
    private double sumGoal;
    private double sumInMonth;

    MoneyBoxBody(int countMonths, double sumGoal) {
        this.countMonths = countMonths;
        this.sumGoal = sumGoal;
    }

    public double getSumGoal() {
        return sumGoal;
    }

    public int getCountMonths() {
        return countMonths;
    }

    public double getSumInMonth() {
        return sumInMonth;
    }

}
