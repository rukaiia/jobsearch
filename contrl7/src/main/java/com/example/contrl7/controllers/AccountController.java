package com.example.contrl7.controllers;


import com.example.contrl7.model.Account;
import com.example.contrl7.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@AllArgsConstructor
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/balance")
    public void updateBalance(@RequestBody Account account) {
        accountService.updateBalance(account.getId(), account.getBalance());
    }

    @GetMapping("/balance")
    public Optional<Account> getBalance(@RequestParam Integer accountId) {
        return accountService.getAccount(accountId);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) {
        accountService.createAccount(account);
    }

}

