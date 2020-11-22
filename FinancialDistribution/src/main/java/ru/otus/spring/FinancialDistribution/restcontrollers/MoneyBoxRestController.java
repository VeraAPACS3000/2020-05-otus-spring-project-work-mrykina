package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.FinancialDistribution.services.MoneyBoxServices;

@RestController
public class MoneyBoxRestController {

    MoneyBoxServices services;

    MoneyBoxRestController(MoneyBoxServices services) {
        this.services = services;
    }

    @PostMapping("/api/moneybox/calculate/amountinmonth")
    public double calculateAmountInMonthToGoal(@RequestBody MoneyBoxBody moneyBoxBody) {
        return services.getAmountInMonthToGoal(moneyBoxBody.getCountMonths(),
                moneyBoxBody.getSumGoal());
    }

    @PostMapping("/api/moneybox/calculate/countmonthstogoal")
    public int calculateCountMonthsToGoal(@RequestBody MoneyBoxBody moneyBoxBody) {
        return services.getCountMonthsToGoal(moneyBoxBody.getSumInMonth(),
                moneyBoxBody.getSumGoal());
    }
}
