package com.fincore.fincore.service;

import com.fincore.fincore.dto.CreateTransactionRequest;
import com.fincore.fincore.dto.TransactionResponse;
import com.fincore.fincore.entity.Category;
import com.fincore.fincore.entity.Transaction;
import com.fincore.fincore.mapper.TransactionMapper;
import com.fincore.fincore.repository.CategoryRepository;
import com.fincore.fincore.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final TransactionMapper transactionMapper;

    public List<TransactionResponse> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::toResponse)
                .toList();
    }

    public List<TransactionResponse> getTransactionsByCategory(UUID categoryId) {
        return transactionRepository.findByCategoryId(categoryId).stream()
                .map(transactionMapper::toResponse)
                .toList();
    }

    @Transactional
    public TransactionResponse createTransaction(CreateTransactionRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id: " + request.categoryId()));

        Transaction transaction = transactionMapper.toEntity(request);
        transaction.setCategory(category);

        Transaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toResponse(savedTransaction);
    }
}