package com.fincore.fincore.controller;

import com.fincore.fincore.dto.CategoryResponse;
import com.fincore.fincore.dto.CreateCategoryRequest;
import com.fincore.fincore.dto.CreateTransactionRequest;
import com.fincore.fincore.dto.TransactionResponse;
import com.fincore.fincore.entity.Transaction;
import com.fincore.fincore.service.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<TransactionResponse> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/category/{categoryId}")
    public List<TransactionResponse> getTransactionsByCategory(@PathVariable UUID categoryId) {
        return transactionService.getTransactionsByCategory(categoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse createTransaction(@Valid @RequestBody CreateTransactionRequest request) {
        return transactionService.createTransaction(request);
    }
}
