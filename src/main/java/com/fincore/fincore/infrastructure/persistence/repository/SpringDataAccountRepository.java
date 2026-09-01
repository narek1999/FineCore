package com.fincore.fincore.infrastructure.persistence.repository;

import com.fincore.fincore.infrastructure.persistence.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataAccountRepository extends JpaRepository<AccountEntity, UUID> {

}