package com.example.s26766bank;

import com.example.s26766bank.model.Account;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    public void testSetAndGetId() {
        // Given
        Account account = new Account();

        // When
        account.setId(1L);

        // Then
        assertEquals(1L, account.getId());
    }

    @Test
    public void testSetAndGetPesel() {
        // Given
        Account account = new Account();

        // When
        account.setPesel("12345678901");

        // Then
        assertEquals("12345678901", account.getPesel());
    }

    @Test
    public void testSetAndGetBalance() {
        // Given
        Account account = new Account();

        // When
        account.setBalance(BigDecimal.valueOf(1000));

        // Then
        assertEquals(BigDecimal.valueOf(1000), account.getBalance());
    }

    @Test
    public void testSetAndGetCurrency() {
        // Given
        Account account = new Account();

        // When
        account.setCurrency("PLN");

        // Then
        assertEquals("PLN", account.getCurrency());
    }

    @Test
    public void testSetAndGetOwnerFirstName() {
        // Given
        Account account = new Account();

        // When
        account.setOwnerFirstName("John");

        // Then
        assertEquals("John", account.getOwnerFirstName());
    }

    @Test
    public void testSetAndGetOwnerLastName() {
        // Given
        Account account = new Account();

        // When
        account.setOwnerLastName("Doe");

        // Then
        assertEquals("Doe", account.getOwnerLastName());
    }

    @Test
    public void testDefaultValues() {
        // Given
        Account account = new Account();

        // Then
        assertNull(account.getId());
        assertNull(account.getPesel());
        assertNull(account.getBalance());
        assertNull(account.getCurrency());
        assertNull(account.getOwnerFirstName());
        assertNull(account.getOwnerLastName());
    }
}
