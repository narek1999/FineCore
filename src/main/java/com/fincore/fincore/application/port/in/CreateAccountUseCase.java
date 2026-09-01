package com.fincore.fincore.application.port.in;

import com.fincore.fincore.domain.model.Account;

import java.util.UUID;

public interface CreateAccountUseCase {
    Account createAccount(UUID userId, String name);
}