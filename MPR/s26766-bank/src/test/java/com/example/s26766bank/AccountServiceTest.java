package com.example.s26766bank;

import com.example.s26766bank.model.Account;
import com.example.s26766bank.repository.AccountRepository;
import com.example.s26766bank.service.AccountService;
import com.example.s26766bank.service.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService = new AccountServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterAccount() {
        // Given
        String pesel = "12345678901";
        BigDecimal initialBalance = BigDecimal.valueOf(1000);
        String currency = "PLN";
        String ownerFirstName = "John";
        String ownerLastName = "Doe";

        // When
        accountService.registerAccount(pesel, initialBalance, currency, ownerFirstName, ownerLastName);

        // Then
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void testGetAccountById() {
        Long accountId = 1L;
        when(accountRepository.findById(accountId)).thenReturn(createTestAccount(accountId));

        Account result = accountService.getAccountById(accountId);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(accountId);
    }

    @Test
    void testGetAccountsByMinBalance() {

        BigDecimal minBalance = BigDecimal.valueOf(500);
        when(accountRepository.findAllByBalanceGreaterThan(minBalance))
                .thenReturn(Arrays.asList(createTestAccount(1L), createTestAccount(2L)));


        List<Account> result = accountService.getAccountsByMinBalance(minBalance);

        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
    }

    private Account createTestAccount(Long id) {
        Account account = new Account();
        account.setId(id);
        account.setPesel("12345678901");
        account.setBalance(BigDecimal.valueOf(1000));
        account.setCurrency("PLN");
        account.setOwnerFirstName("John");
        account.setOwnerLastName("Doe");
        return account;
    }
}

