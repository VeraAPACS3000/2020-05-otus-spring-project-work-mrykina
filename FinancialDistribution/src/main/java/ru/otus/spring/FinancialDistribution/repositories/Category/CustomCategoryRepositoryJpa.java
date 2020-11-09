package ru.otus.spring.FinancialDistribution.repositories.Category;

import ru.otus.spring.FinancialDistribution.models.Category;
import ru.otus.spring.FinancialDistribution.restcontrollers.CategoryBody;

import java.util.Map;


public interface CustomCategoryRepositoryJpa {
    void updateBalanceOnCategory(Map<Long, Double> mapToUpdate);

    void updateActiveCategory(Long id, int status);

    public Category toCategory(CategoryBody bodyCategory);
}
