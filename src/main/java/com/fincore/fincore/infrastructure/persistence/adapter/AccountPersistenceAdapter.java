package com.fincore.fincore.infrastructure.persistence.adapter;

import com.fincore.fincore.application.port.out.AccountRepositoryPort;
import com.fincore.fincore.domain.model.Account;
import com.fincore.fincore.infrastructure.persistence.entity.AccountEntity;
import com.fincore.fincore.infrastructure.persistence.mapper.AccountMapper;
import com.fincore.fincore.infrastructure.persistence.repository.SpringDataAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AccountPersistenceAdapter implements AccountRepositoryPort {

    private final SpringDataAccountRepository repository;
    private final AccountMapper accountMapper;

    @Override
    public Account save(Account account) {
        AccountEntity entity = accountMapper.toEntity(account);

        AccountEntity savedEntity = repository.save(entity);

        return accountMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Account> findById(UUID id) {
        Optional<AccountEntity> searchedAccount = repository.findById(id);

        return searchedAccount.map(accountMapper::toDomain);
    }
}