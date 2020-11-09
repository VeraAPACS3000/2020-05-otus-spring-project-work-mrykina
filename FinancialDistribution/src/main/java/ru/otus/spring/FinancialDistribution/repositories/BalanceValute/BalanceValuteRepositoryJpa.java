package ru.otus.spring.FinancialDistribution.repositories.BalanceValute;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.spring.FinancialDistribution.models.BalanceValute;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BalanceValuteRepositoryJpa extends CrudRepository<BalanceValute, Long> {

    @EntityGraph(value = "balances-categories-graph")
    List<BalanceValute> findAll();

    @EntityGraph(value = "balances-categories-graph")
    List<BalanceValute> findByDate(LocalDate date);
}
