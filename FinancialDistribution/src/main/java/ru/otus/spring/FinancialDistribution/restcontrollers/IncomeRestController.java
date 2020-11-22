package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.FinancialDistribution.models.Income;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.IncomeDto;
import ru.otus.spring.FinancialDistribution.services.IncomeServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IncomeRestController {

    IncomeServices service;

    IncomeRestController(IncomeServices service) {
        this.service = service;
    }

    @GetMapping("/api/incomes/list")
    public List<Income> getListIncomes() {
        return service.getListIncomes();
    }

    @GetMapping("/api/incomes/get")
    public IncomeDto getIncome(@RequestBody IncomeDto incomeDto) {
        return IncomeDto.toDto(service.getIncome(incomeDto.getIdCategory()).get());
    }

    @GetMapping("/api/incomes/list_by_category")
    public List<IncomeDto> listIncomesByCategory(@RequestBody IncomeDto incomeDto) {
        return service.getListIncomesCategory(incomeDto.getIdCategory()).stream().map(
                IncomeDto::toDto
        ).collect(Collectors.toList());
    }

    @PostMapping("/api/incomes/add")
    public void addNewIncome(@RequestBody IncomeDto incomeDto) {
        service.addIncome(incomeDto);
    }
}
