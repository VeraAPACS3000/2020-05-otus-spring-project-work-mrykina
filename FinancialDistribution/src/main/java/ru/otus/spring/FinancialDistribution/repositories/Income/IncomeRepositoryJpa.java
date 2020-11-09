package ru.otus.spring.FinancialDistribution.repositories.Income;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.spring.FinancialDistribution.models.Income;

import java.util.List;

@Repository
public interface IncomeRepositoryJpa extends CrudRepository<Income, Long> {

    List<Income> findByIdCategory(Long idCategory);
}
