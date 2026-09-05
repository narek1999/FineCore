package com.fincore.fincore.infrastructure.persistence.mapper;

import com.fincore.fincore.domain.model.Account;
import com.fincore.fincore.infrastructure.persistence.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account toDomain(AccountEntity entity);

    AccountEntity toEntity(Account domain);
}