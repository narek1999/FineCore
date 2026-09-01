package com.fincore.fincore.infrastructure.web.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record AccountResponse(
        UUID id,
        UUID userId,
        String name,
        OffsetDateTime createdAt
) {}