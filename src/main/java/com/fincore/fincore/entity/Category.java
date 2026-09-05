package com.fincore.fincore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "monthly_budget")
    private BigDecimal monthlyBudget;

    public Category() {
    }

    public Category(String name, BigDecimal monthlyBudget) {
        this.name = name;
        this.monthlyBudget = monthlyBudget;
    }
}
