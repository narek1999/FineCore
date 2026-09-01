package com.fincore.fincore.infrastructure.web.controller;

import com.fincore.fincore.application.port.in.CreateAccountUseCase;
import com.fincore.fincore.application.port.in.GetAccountQuery;
import com.fincore.fincore.domain.model.Account;
import com.fincore.fincore.infrastructure.web.dto.AccountResponse;
import com.fincore.fincore.infrastructure.web.dto.CreateAccountRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountQuery getAccountQuery;

    public AccountController (CreateAccountUseCase createAccountUseCase, GetAccountQuery getAccountQuery) {
        this.createAccountUseCase = createAccountUseCase;
        this.getAccountQuery = getAccountQuery;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        Account createdAccount = createAccountUseCase.createAccount(
                request.userId(),
                request.name()
        );

        return new AccountResponse(
                createdAccount.id(),
                createdAccount.userId(),
                createdAccount.name(),
                createdAccount.createdAt()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable UUID id) {
        return getAccountQuery.getAccount(id)
                .map(account -> ResponseEntity.ok(new AccountResponse(
                        account.id(),
                        account.userId(),
                        account.name(),
                        account.createdAt()
                )))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}