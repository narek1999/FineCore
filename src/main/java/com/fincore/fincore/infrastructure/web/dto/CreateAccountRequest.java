package com.fincore.fincore.infrastructure.web.dto;

import java.util.UUID;

public record CreateAccountRequest(
        UUID userId,
        String name
) {}