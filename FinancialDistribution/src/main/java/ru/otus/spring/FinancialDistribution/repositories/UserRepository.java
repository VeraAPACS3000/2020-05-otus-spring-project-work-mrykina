package ru.otus.spring.FinancialDistribution.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.FinancialDistribution.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
