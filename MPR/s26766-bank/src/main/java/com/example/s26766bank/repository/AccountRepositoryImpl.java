package com.example.s26766bank.repository;

import com.example.s26766bank.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account account) {
        accounts.add(account);
    }

    @Override
    public Account findById(Long id) {
        return accounts.stream()
                .filter(account -> id.equals(account.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Account> findAllByBalanceGreaterThan(BigDecimal minBalance) {
        return accounts.stream()
                .filter(account -> account.getBalance() != null && account.getBalance().compareTo(minBalance) > 0)
                .toList();
    }
}
