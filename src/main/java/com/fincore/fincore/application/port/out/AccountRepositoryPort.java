package com.fincore.fincore.application.port.out;

import com.fincore.fincore.domain.model.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepositoryPort {
    Account save(Account account);
    Optional<Account> findById(UUID id);
}