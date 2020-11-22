package ru.otus.spring.FinancialDistribution.pagecontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.otus.spring.FinancialDistribution.services.CategoryServices;

@Controller
public class CategoryController {

    private final CategoryServices services;

    public CategoryController(CategoryServices services) {
        this.services = services;
    }

    @GetMapping("/accessDenied")
    public String accessDeniedPage() {
        return "accessDenied";
    }

    @GetMapping("/")
    public String getIndex() {
        System.out.println("index");
        return "index";
    }

    @GetMapping("/activeCategories")
    public String getListCategories( ) {
        System.out.println("activeCategories");
        return "listCategories";
    }

    @GetMapping("/addNewCategory")
    public String addNewCategory() {
        System.out.println("newCategory");
        return "newCategory";
    }
}
