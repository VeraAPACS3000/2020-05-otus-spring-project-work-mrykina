package ru.otus.spring.FinancialDistribution.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "INCOME")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_category", nullable = true)
    private Long idCategory;

    @Column(name = "amount", nullable = true)
    private Double amount;

    @Column(name = "date", nullable = true)
    private LocalDate date = LocalDate.now();

    public Income() {

    }

    public Income(Long id, Long idCategory, Double amount,
                  LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.idCategory = idCategory;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
