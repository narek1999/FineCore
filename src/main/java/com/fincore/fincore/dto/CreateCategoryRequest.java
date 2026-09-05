package com.fincore.fincore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateCategoryRequest(

        @NotBlank(message = "Category name is required") String name,

        @Positive(message = "Monthly budget must be positive") BigDecimal monthlyBudget) {
}