package com.fincore.fincore.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CategoryResponse(UUID id, String name, BigDecimal monthlyBudget) {
}
