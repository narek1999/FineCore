package com.fincore.fincore.application.service;

import com.fincore.fincore.application.port.in.GetAccountQuery;
import com.fincore.fincore.application.port.out.AccountRepositoryPort;
import com.fincore.fincore.domain.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetAccountService implements GetAccountQuery {

    private final AccountRepositoryPort repositoryPort;

    public GetAccountService(AccountRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Optional<Account> getAccount(UUID id) {
        return repositoryPort.findById(id);
    }
}