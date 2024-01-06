package net.ahmed.customerservice.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import net.ahmed.customerservice.enums.AccountType;

import java.time.LocalDate;

public class BankAccount {


    private String accountId;
    private double balance;
    private LocalDate createdAt;

    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;


}
