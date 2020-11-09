package ru.otus.spring.FinancialDistribution.repositories.Expense;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.spring.FinancialDistribution.models.Expense;
import ru.otus.spring.FinancialDistribution.repositories.Category.CustomCategoryRepositoryJpa;

import java.util.List;

@Repository
public interface ExpenseRepositoryJpa extends CustomCategoryRepositoryJpa, CrudRepository<Expense, Long> {
    List<Expense> findByIdCategory(Long idCategory);
}
