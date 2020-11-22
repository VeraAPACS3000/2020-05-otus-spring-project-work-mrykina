package ru.otus.spring.FinancialDistribution.repositories.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.spring.FinancialDistribution.models.Category;

import java.util.List;

@Repository
public interface CategoryRepositoryJpa extends CrudRepository<Category, Long>,  CustomCategoryRepositoryJpa{
    List<Category> findByActive(int state);

    @Override
    void deleteById(Long aLong);
}
