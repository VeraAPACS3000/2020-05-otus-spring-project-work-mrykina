package ru.otus.spring.FinancialDistribution.services;

import ru.otus.spring.FinancialDistribution.exceptions.ExceptionCalculate;
import ru.otus.spring.FinancialDistribution.models.Category;
import ru.otus.spring.FinancialDistribution.restcontrollers.CategoryBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CategoryServices {
    List<Category> getListAllCategories();

    List<Category> getListActiveCategories();

    void addNewCategory(CategoryBody category);

    Map<Long, Double> calculatePercentsOnCategories(Double totalAmount) throws ExceptionCalculate;

    void updateBalances(Map<Long, Double> mapToUpdate);

    void updateActiveCategory(Long id, int status);

    void deleteCategory(Long id);

    Optional<Category> getCategory(Long id);
}
