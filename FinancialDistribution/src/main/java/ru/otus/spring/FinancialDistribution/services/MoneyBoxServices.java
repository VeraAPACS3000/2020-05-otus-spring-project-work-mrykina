package ru.otus.spring.FinancialDistribution.services;

public interface MoneyBoxServices {
    double getAmountInMonthToGoal(int countMonths, double goalSum);

    int getCountMonthsToGoal(double sumInMonth, double goalSum);
}
