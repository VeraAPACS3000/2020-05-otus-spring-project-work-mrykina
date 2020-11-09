package ru.otus.spring.FinancialDistribution.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.spring.FinancialDistribution.models.Income;
import ru.otus.spring.FinancialDistribution.repositories.Income.IncomeRepositoryJpa;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@DisplayName("IncomeRepositoryJpa должен")
@DataJpaTest
public class IncomeRepositoryJpaTest {

    @Autowired
    IncomeRepositoryJpa repository;

    @DisplayName("загружать доход по id дохода")
    @Test
    void shouldFindById() {
        Optional<Income> income = repository.findById(1L);
        assertThat(income).isPresent().get().isNotNull();
    }
}
