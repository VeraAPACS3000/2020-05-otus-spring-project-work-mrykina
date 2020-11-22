package ru.otus.spring.FinancialDistribution.restcontrollers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.spring.FinancialDistribution.exceptions.ExceptionCalculate;
import ru.otus.spring.FinancialDistribution.models.Category;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.CategoryDto;
import ru.otus.spring.FinancialDistribution.services.CategoryServices;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@Api(value = "Сервисы контроллера")
public class CategoryRestController {

    private final CategoryServices services;

    CategoryRestController(CategoryServices services) {
        this.services = services;
    }

    @ApiOperation(value = "СПИСОК ВСЕХ КАТЕГОРИЙ", response = Iterable.class)
    @GetMapping("/api/categories_all")
    public List<CategoryDto> getListAllCategories() {
        List<CategoryDto> listCategoryDto = services.getListAllCategories().stream().map(CategoryDto::toDto).collect(Collectors.toList());
        return listCategoryDto;
    }

    @ApiOperation(value = "СПИСОК АКТИВНЫХ КАТЕГОРИЙ", response = Iterable.class)
    @GetMapping("/api/categories_active")
    public List<CategoryDto> getListActiveCategories() {
        System.out.println("rest cont:" + services.getListActiveCategories());
        List<CategoryDto> listCategoryDto = services.getListActiveCategories().stream().map(CategoryDto::toDto).collect(Collectors.toList());
        return listCategoryDto;
    }

    @ApiOperation(value = "ПОСМОТРЕТЬ КАТЕГОРИЮ", response = Iterable.class)
    @GetMapping("/api/categories/category/get")
    public Category getCategory(@RequestBody CategoryBody category) {
        return services.getCategory(category.getId()).get();

    }

    @ApiOperation(value = "ДОБАВИТЬ КАТЕГОРИЮ", response = Iterable.class)
    @PostMapping("/api/categories/add_category")
    public void addNewCategory(@RequestBody CategoryBody newCategory) {
        services.addNewCategory(newCategory);
    }

    @ApiOperation(value = "РАССЧИТАТЬ ПРОЦЕНТЫ ДЛЯ КАЖДОЙ КАТЕГОРИИ", response = Iterable.class)
    @PostMapping("/api/categories/calculate")
    public Map<Long, Double> getMapCalculatePercents(@RequestBody String totalAmount) throws ExceptionCalculate {
        Double amount = Double.parseDouble(totalAmount);
        return services.calculatePercentsOnCategories(amount);
    }

    @ApiOperation(value = "ИЗМЕНИТЬ БАЛАНС ДЛЯ КАЖДОЙ КАТЕГОРИИ", response = Iterable.class)
    @PostMapping("/api/categories/updateBalances")
    public void updateBalancesCategories(@RequestBody Map<Long, Double> mapToUpdateBalancesCategories) {
        services.updateBalances(mapToUpdateBalancesCategories);
    }

    @ApiOperation(value = "СДЕЛАТЬ КАТЕГОРИЮ АКТИВНОЙ", response = Iterable.class)
    @PostMapping("/api/categories/category/updateActive")
    public void updateActiveCategory(@RequestBody CategoryBody category) {
        services.updateActiveCategory(category.getId(), category.getActive());
    }

    @ApiOperation(value = "УДАЛИТЬ КАТЕГОРИЮ", response = Iterable.class)
    @PostMapping(value = "/api/categories/category/delete")
    public void deleteCategory(@RequestBody CategoryBody category) {
        services.deleteCategory(category.getId());
    }

}
