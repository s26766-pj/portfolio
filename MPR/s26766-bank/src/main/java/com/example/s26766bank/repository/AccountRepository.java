package com.example.s26766bank.repository;

import com.example.s26766bank.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface AccountRepository {
    void save(Account account);
    Account findById(Long id);
    List<Account> findAllByBalanceGreaterThan(BigDecimal minBalance);
}

