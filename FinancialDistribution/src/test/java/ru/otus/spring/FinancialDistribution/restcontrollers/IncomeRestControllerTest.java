package ru.otus.spring.FinancialDistribution.restcontrollers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.spring.FinancialDistribution.Utils.Convertor;
import ru.otus.spring.FinancialDistribution.restcontrollers.dto.IncomeDto;
import ru.otus.spring.FinancialDistribution.services.IncomeServices;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("REST-контроллер IncomeRestController должен ")
@WebMvcTest(IncomeRestController.class)
public class IncomeRestControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    IncomeRestController controller;

    @MockBean
    IncomeServices services;

    @DisplayName("Контекст успешно создаёт контроллер SpendingRestController")
    @Test
    public void shouldCorrectCreateController() {
        assertThat(controller).isNotNull();
    }

    @DisplayName("возвращать список всех категорий доходов.GET")
    @Test
    public void shouldGetListAllIncomes() throws Exception {
        mvc.perform(get("/api/incomes/list")).andExpect(status().isOk());
    }

    @DisplayName("добавлять доходы по категиям.POST")
    @Test
    public void shouldAddIncomes() throws Exception {
        LocalDate date = LocalDate.now();

        IncomeDto income = new IncomeDto(
                3,
                1l,
                177d,
                date
        );
        mvc.perform(post("/api/incomes/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Convertor.toJson(income))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("возвращать доходо по id категории.GET")
    @Test
    public void shouldGetIncome() throws Exception {
        LocalDate date = LocalDate.now();

        IncomeDto income = new IncomeDto(
                1l,
                1l,
                177d,
                date
        );

        mvc.perform(get("/api/incomes/get")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Convertor.toJson(income))
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

}
