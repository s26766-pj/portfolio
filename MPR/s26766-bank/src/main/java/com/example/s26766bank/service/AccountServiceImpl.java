package com.example.s26766bank.service;

import com.example.s26766bank.model.Account;
import com.example.s26766bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void registerAccount(String pesel, BigDecimal initialBalance, String currency, String ownerFirstName, String ownerLastName) {

    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> getAccountsByMinBalance(BigDecimal minBalance) {
        return accountRepository.findAllByBalanceGreaterThan(minBalance);
    }
}

