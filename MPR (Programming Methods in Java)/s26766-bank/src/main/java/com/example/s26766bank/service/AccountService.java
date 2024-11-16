package com.example.s26766bank.service;

import com.example.s26766bank.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface AccountService {
    void registerAccount(String pesel, BigDecimal initialBalance, String currency, String ownerFirstName, String ownerLastName);

    Account getAccountById(Long id);
    List<Account> getAccountsByMinBalance(BigDecimal minBalance);
}

