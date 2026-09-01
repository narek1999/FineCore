package com.fincore.fincore.application.port.in;

import com.fincore.fincore.domain.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface GetAccountQuery {
    Optional<Account> getAccount(UUID id);
}