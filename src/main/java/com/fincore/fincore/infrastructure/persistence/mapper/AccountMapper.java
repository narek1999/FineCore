package com.fincore.fincore.infrastructure.persistence.mapper;

import com.fincore.fincore.domain.model.Account;
import com.fincore.fincore.infrastructure.persistence.entity.AccountEntity;

public class AccountMapper {

    public static Account toDomain(AccountEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Account(
                entity.getId(),
                entity.getUserId(),
                entity.getName(),
                entity.getCreatedAt()
        );
    }

    public static AccountEntity toEntity(Account domain) {
        if (domain == null) {
            return null;
        }

        AccountEntity entity = new AccountEntity();

        entity.setId(domain.id());
        entity.setUserId(domain.userId());
        entity.setName(domain.name());
        entity.setCreatedAt(domain.createdAt());

        return entity;
    }
}