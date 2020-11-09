package ru.otus.spring.FinancialDistribution.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EXPENSE")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_category", nullable = true)
    private Long idCategory;

    @Column(name = "amount", nullable = true)
    private Double amount;

    @Column(name = "date", nullable = true)
    private LocalDate date = LocalDate.now();

    public Expense() {
    }

    public Expense(Long id, Long idCategory, Double amount, LocalDate date) {
        this.id = id;
        this.idCategory = idCategory;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
