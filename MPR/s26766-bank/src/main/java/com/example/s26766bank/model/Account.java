package com.example.s26766bank.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Component
public class Account {

    private Long id;

    private String pesel;

    private BigDecimal balance;

    private String currency;

    private String ownerFirstName;

    private String ownerLastName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

}
