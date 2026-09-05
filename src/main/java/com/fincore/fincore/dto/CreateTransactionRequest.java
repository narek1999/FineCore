package com.fincore.fincore.dto;

import com.fincore.fincore.entity.TransactionType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateTransactionRequest(

        @NotNull(message = "Amount is required") @Positive(message = "Amount must be positive") BigDecimal amount,

        @NotNull(message = "Transaction type is required") TransactionType type,

        @NotNull(message = "Category ID is required") UUID categoryId, String description

) {
}
