package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.spring.FinancialDistribution.Utils.Convertor;
import ru.otus.spring.FinancialDistribution.services.CategoryServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("REST-контроллер CategoryRestController должен ")
@WebMvcTest(CategoryRestController.class)
public class CategoryRestControllerTest {

    private final String DELETE_ID_CATEGORY = "1";

    @Autowired
    MockMvc mvc;

    @Autowired
    CategoryRestController controller;

    @MockBean
    CategoryServices services;

    @DisplayName("успешно удалять категорию. POST-request")
    @Test
    public void shouldDeleteCategory() throws Exception {
        CategoryBody categoryBody = new CategoryBody(
                DELETE_ID_CATEGORY,
                "name",
                "1",
                "1",
                "",
                "1",
                "1");

        mvc.perform(post("/api/categories/category/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Convertor.toJson(categoryBody))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("Контекст успешно создаёт контроллер CategoryRestControllerTest")
    @Test
    public void shouldCorrectCreateController() {
        assertThat(controller).isNotNull();
    }

    /*
    @DisplayName("возвращать категорию по id категории")
    @Test
    public void shouldGetCategory() throws Exception {
        CategoryBody category = new CategoryBody(
                7l,
"test",
        10d,
        10d,
        "no",
        10d,
        7
        );
        mvc.perform(get("/api/categories/category/get")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Convertor.toJson(category))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }*/
}
