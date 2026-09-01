package com.fincore.fincore.infrastructure.persistence.adapter;

import com.fincore.fincore.application.port.out.AccountRepositoryPort;
import com.fincore.fincore.domain.model.Account;
import com.fincore.fincore.infrastructure.persistence.mapper.AccountMapper;
import com.fincore.fincore.infrastructure.persistence.entity.AccountEntity;
import com.fincore.fincore.infrastructure.persistence.repository.SpringDataAccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AccountPersistenceAdapter implements AccountRepositoryPort {
    private final SpringDataAccountRepository repository;


    public AccountPersistenceAdapter(SpringDataAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = AccountMapper.toEntity(account);

        AccountEntity savedEntity = repository.save(entity);

        return AccountMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        Optional<AccountEntity> searchedAccount = repository.findById(id);
        return searchedAccount.map(AccountMapper::toDomain);
    }
}