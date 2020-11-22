package ru.otus.spring.FinancialDistribution.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.otus.spring.FinancialDistribution.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
