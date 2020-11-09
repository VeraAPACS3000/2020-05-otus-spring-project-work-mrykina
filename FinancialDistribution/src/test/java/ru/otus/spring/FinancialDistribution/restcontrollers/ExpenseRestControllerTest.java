package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.spring.FinancialDistribution.services.ExpenseServices;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("REST-контроллер ExpenseRestController должен ")
@WebMvcTest(ExpenseRestController.class)
public class ExpenseRestControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ExpenseRestController controller;

    @MockBean
    ExpenseServices services;

    @DisplayName("Контекст успешно создаёт контроллер ExpenseRestController")
    @Test
    public void shouldCorrectCreateController() {
        assertThat(controller).isNotNull();
    }

    @DisplayName("успешно возвращать список расходов.GET")
    @Test
    public void shouldGetListExpenses() throws Exception {
        mvc.perform(get("/api/expenses/list")).andExpect(status().isOk());
    }

}
