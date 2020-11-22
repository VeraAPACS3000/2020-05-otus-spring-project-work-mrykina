package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;

/**
 * В базу не обращаемся, голые расчёты
 */
@Service
public class MoneyBoxServicesImpl implements MoneyBoxServices {
    @Override
    public double getAmountInMonthToGoal(int countMonths, double goalSum) {
        double result = 0d;
        if (countMonths > 0 && goalSum > 0) {
            result = goalSum / countMonths;
        }
        return result;
    }

    @Override
    public int getCountMonthsToGoal(double sumInMonth, double goalSum) {
        int result = 0;
        if (sumInMonth > 0 && goalSum > 0) {
            double resultDouble = goalSum / sumInMonth;
            result = (int) resultDouble;
        }
        return 0;
    }
}
