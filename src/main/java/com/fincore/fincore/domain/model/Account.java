package com.fincore.fincore.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Account(
        UUID id,
        UUID userId,
        String name,
        OffsetDateTime createdAt
) {}