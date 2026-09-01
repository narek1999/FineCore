package com.fincore.fincore.infrastructure.web.controller;

import com.fincore.fincore.application.port.in.CreateAccountUseCase;
import com.fincore.fincore.domain.model.Account;
import com.fincore.fincore.infrastructure.web.dto.AccountResponse;
import com.fincore.fincore.infrastructure.web.dto.CreateAccountRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final CreateAccountUseCase createAccountUseCase;

    public AccountController (CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
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
}