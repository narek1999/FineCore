package com.fincore.fincore.dto;

import com.fincore.fincore.entity.TransactionType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record TransactionResponse(UUID id, BigDecimal amount, TransactionType type, CategoryResponse category,
                                  String description, OffsetDateTime createdAt) {
}
