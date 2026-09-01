package com.fincore.fincore.application.service;

import com.fincore.fincore.application.port.in.CreateAccountUseCase;
import com.fincore.fincore.application.port.out.AccountRepositoryPort;
import com.fincore.fincore.domain.model.Account;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class CreateAccountService implements CreateAccountUseCase {

    private final AccountRepositoryPort repositoryPort;

    public CreateAccountService(AccountRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Account createAccount(UUID userId, String name) {
        Account newAccount = new Account(
                null,
                userId,
                name,
                OffsetDateTime.now()
        );

        return repositoryPort.save(newAccount);
    }
}