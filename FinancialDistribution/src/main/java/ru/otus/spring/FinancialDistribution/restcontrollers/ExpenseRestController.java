package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.ExpenseDto;
import ru.otus.spring.FinancialDistribution.services.ExpenseServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpenseRestController {

    private final ExpenseServices services;

    ExpenseRestController(ExpenseServices services) {
        this.services = services;
    }

    @GetMapping("/api/expenses/list")
    public List<ExpenseDto> listSpending() {
        return services.getListAllExpenses().stream().map(
                ExpenseDto::toDto
        ).collect(Collectors.toList());
    }

    @GetMapping("/api/expenses/list_by_category")
    public List<ExpenseDto> listExpensesByCategory(@RequestBody ExpenseDto expenseDto) {
        return services.getListExpensesCategory(expenseDto.getIdCategory()).stream().map(
                ExpenseDto::toDto
        ).collect(Collectors.toList());
    }

    @PostMapping("/api/expenses/add")
    public void addNewExpense(@RequestBody ExpenseDto expenseDto) {
        services.addExpense(expenseDto);
    }


}
