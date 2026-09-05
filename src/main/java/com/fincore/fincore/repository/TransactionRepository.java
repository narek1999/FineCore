package com.fincore.fincore.repository;

import com.fincore.fincore.entity.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    List<Transaction> findByCategoryId(UUID categoryId);

    Example<? extends Transaction> id(UUID id);
}
