package ru.otus.spring.FinancialDistribution.repositories.Category;

import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.spring.FinancialDistribution.models.Category;
import ru.otus.spring.FinancialDistribution.restcontrollers.CategoryBody;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class CustomCategoryRepositoryJpaImpl implements CustomCategoryRepositoryJpa {

    private static Logger log = Logger.getLogger(CustomCategoryRepositoryJpaImpl.class.getName());

    @Autowired
    CategoryRepositoryJpa categoryRepositoryJpa;

    CustomCategoryRepositoryJpaImpl(CategoryRepositoryJpa categoryRepositoryJpa) {
        this.categoryRepositoryJpa = categoryRepositoryJpa;
    }

    //TODO проверку сделать как себя вести если нет категории
    @Override
    public void updateBalanceOnCategory(Map<Long, Double> mapToUpdate) {
        for (Map.Entry<Long, Double> balance : mapToUpdate.entrySet()) {
            Optional<Category> categoryOptional = categoryRepositoryJpa.findById(balance.getKey());
            if (categoryOptional.isPresent()) {
                Category category = categoryOptional.get();
                Double currentBalance = category.getBalance();
                Double sumBalance = currentBalance + balance.getValue();
                category.setBalance(sumBalance);
                categoryRepositoryJpa.save(category);
            } else {
                log.warning("updateBalanceOnCategory is null");
            }
        }
    }

    @Override
    public void updateActiveCategory(Long id, int status) {
        Optional<Category> categoryOptional = categoryRepositoryJpa.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.setActive(status);
            categoryRepositoryJpa.save(category);
        } else {
            log.warning("updateActiveCategory is null");
        }
    }

    public Category toCategory(CategoryBody bodyCategory) {
        Category newCategory = new Category(
                bodyCategory.getName(),
                bodyCategory.getBalance(),
                bodyCategory.getPercent(),
                bodyCategory.getComment(),
                bodyCategory.getPurposeAmount(),
                bodyCategory.getActive()
        );
        return newCategory;
    }

}
