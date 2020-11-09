package ru.otus.spring.FinancialDistribution.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedEntityGraphs(value = {
        @NamedEntityGraph(
                name = "balances-categories-graph",
                attributeNodes = @NamedAttributeNode("idCategory")
        )
})
@Table(name = "BALANCES")
public class BalanceValute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_category", nullable = true)
    private Long idCategory;

    @Column(name = "valute", nullable = true)
    private String valute;

    @Column(name = "balance", nullable = true)
    private Double balance;

    @Column(name = "date", nullable = true)
    private LocalDate date = LocalDate.now();

    BalanceValute() {
    }

    public BalanceValute(Long idCategory, String valute, Double balance) {
        this.idCategory = idCategory;
        this.valute = valute;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public String getValute() {
        return valute;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValute(String valute) {
        this.valute = valute;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BalanceValute{" +
                "id=" + id +
                ", idCategory=" + idCategory +
                ", valute='" + valute + '\'' +
                ", balance=" + balance +
                '}';
    }
}
