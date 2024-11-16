package com.example.s26766bank.service;

import lombok.Getter;

import java.math.BigDecimal;


@Getter
public class AccountRequestDTO {

    private String pesel;

    private BigDecimal initialBalance;

    private String currency;

    private String ownerFirstName;

    private String ownerLastName;

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

}
