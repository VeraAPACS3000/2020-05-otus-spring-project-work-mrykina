package ru.otus.spring.FinancialDistribution.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.spring.FinancialDistribution.exceptions.ExceptionCalculate;
import ru.otus.spring.FinancialDistribution.models.Category;
import ru.otus.spring.FinancialDistribution.repositories.Category.CategoryRepositoryJpa;
import ru.otus.spring.FinancialDistribution.restcontrollers.CategoryBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import static ru.otus.spring.FinancialDistribution.utils.Constants.*;

@Service
public class CategoryServicesImpl implements CategoryServices {
    private static Logger log = Logger.getLogger(CategoryServicesImpl.class.getName());

    public CategoryRepositoryJpa repository;

    CategoryServicesImpl(CategoryRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getListAllCategories() {
        List<Category> categoryList = (List<Category>) repository.findAll();
        if (categoryList.isEmpty()) {
            log.info("List all categories is empty");
        }
        return categoryList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getListActiveCategories() {
        List<Category> categoryList = repository.findByActive(stateActive);
        if (categoryList.isEmpty()) {
            log.info("List active categories is empty");
        }
        return categoryList;
    }

    @Override
    @Transactional
    public void addNewCategory(CategoryBody bodyCategory) {
        repository.save(repository.toCategory(bodyCategory));
    }

    @Override
    @Transactional(readOnly = true)
    public Map<Long, Double> calculatePercentsOnCategories(Double totalAmount) throws ExceptionCalculate {
        log.info("start calculatePercentsOnCategories");
        Map<Long, Double> mapPercentsCategories = new HashMap<>();
        List<Category> listActiveCategories = getListActiveCategories();
        if (checkTotalPercentNotOverOneHundred(listActiveCategories) &&
                checkTotalPercentNotZero(listActiveCategories)) {
            //calculate
            for (Category category : listActiveCategories) {
                Long idCategory = category.getId();
                Double percent = category.getPercent();
                Double resultPercent = (totalAmount * percent) / oneHundredPercent;
                mapPercentsCategories.put(idCategory, resultPercent);
            }
        }
        return mapPercentsCategories;
    }

    @Override
    @Transactional
    public void updateBalances(Map<Long, Double> mapToUpdate) {
        repository.updateBalanceOnCategory(mapToUpdate);
    }

    @Override
    @Transactional
    public void updateActiveCategory(Long id, int status) {
        repository.updateActiveCategory(id, status);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Category> getCategory(Long id) {
        return repository.findById(id);
    }

    //check 100 %
    public boolean checkTotalPercentNotOverOneHundred(List<Category> listCategories) throws ExceptionCalculate {
        boolean result = true;
        Double totalSumPercent = 0.00;
        for (Category category : listCategories) {
            totalSumPercent += category.getPercent();
        }
        if (totalSumPercent > oneHundredPercent) {
            throw new ExceptionCalculate("Total sum more 100%");
        }

        return result;
    }

    //check on zero
    public boolean checkTotalPercentNotZero(List<Category> listCategories) throws ExceptionCalculate {
        boolean result = true;

        Double totalSumPercent = 0.00;
        for (Category category : listCategories) {
            totalSumPercent += category.getPercent();
        }
        if (totalSumPercent <= zero) {
            throw new ExceptionCalculate("Total sum less 100%");
        }
        return result;
    }

}
