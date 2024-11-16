package com.example.s26766bank.controller;

import com.example.s26766bank.model.Account;
import com.example.s26766bank.service.AccountRequestDTO;
import com.example.s26766bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public void registerAccount(@RequestBody AccountRequestDTO request) {
        accountService.registerAccount(request.getPesel(), request.getInitialBalance(),
                request.getCurrency(), request.getOwnerFirstName(), request.getOwnerLastName());
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/balance/{minBalance}")
    public List<Account> getAccountsByMinBalance(@PathVariable BigDecimal minBalance) {
        return accountService.getAccountsByMinBalance(minBalance);
    }
}
