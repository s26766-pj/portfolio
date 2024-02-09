package com.example.s26766bank;

import com.example.s26766bank.model.Account;
import com.example.s26766bank.repository.AccountRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountRepositoryImplTest {

    private AccountRepositoryImpl accountRepository;

    @BeforeEach
    public void setUp() {
        accountRepository = new AccountRepositoryImpl();
    }

    @Test
    public void testSaveAndFindById() {
        // Given
        Account account = new Account();
        account.setId(1L);

        // When
        accountRepository.save(account);
        Account foundAccount = accountRepository.findById(1L);

        // Then
        assertEquals(account, foundAccount);
    }

    @Test
    public void testFindByIdNotFound() {
        // When
        Account foundAccount = accountRepository.findById(1L);

        // Then
        assertNull(foundAccount);
    }

    @Test
    public void testFindAllByBalanceGreaterThan() {
        // Given
        Account account1 = new Account();
        account1.setId(1L);
        account1.setBalance(BigDecimal.valueOf(1000));

        Account account2 = new Account();
        account2.setId(2L);
        account2.setBalance(BigDecimal.valueOf(500));

        Account account3 = new Account();
        account3.setId(3L);
        account3.setBalance(BigDecimal.valueOf(1500));

        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);

        // When
        List<Account> result = accountRepository.findAllByBalanceGreaterThan(BigDecimal.valueOf(1000));

        // Then
        assertEquals(1, result.size());
        assertEquals(account3, result.get(0));
    }

    @Test
    public void testFindAllByBalanceGreaterThanEmptyResult() {
        // When
        List<Account> result = accountRepository.findAllByBalanceGreaterThan(BigDecimal.valueOf(2000));

        // Then
        assertEquals(0, result.size());
    }
}
