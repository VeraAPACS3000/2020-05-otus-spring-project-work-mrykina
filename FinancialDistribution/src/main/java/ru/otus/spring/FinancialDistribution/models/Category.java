package ru.otus.spring.FinancialDistribution.models;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedEntityGraphs(value = {
        @NamedEntityGraph(
                name = "categories-balances-graph",
                attributeNodes = {@NamedAttributeNode("balanceValutes")}
        )
})
@Table(name = "CATEGORIES")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "balance", nullable = true)
    private Double balance;

    @Column(name = "percent", nullable = true)
    private Double percent;

    @Column(name = "comment", nullable = true)
    private String comment;

    @Column(name = "purposeamount", nullable = true)
    private Double purposeAmount;

    @Column(name = "active", nullable = true)
    private int active;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private List<Expense> expenses;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private List<Income> incomes;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private List<BalanceValute> balanceValutes;

    public Category() {

    }

    public Category(String name, Double balance, Double percent, String comment, Double purposeAmount, int active) {
        this.name = name;
        this.balance = balance;
        this.percent = percent;
        this.comment = comment;
        this.purposeAmount = purposeAmount;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getPercent() {
        return percent;
    }

    public Double getPurposeAmount() {
        return purposeAmount;
    }

    public String getComment() {
        return comment;
    }

    public int getActive() {
        return active;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", percent=" + percent +
                ", comment='" + comment + '\'' +
                ", purposeAmount=" + purposeAmount +
                ", active=" + active +
                '}';
    }
}
