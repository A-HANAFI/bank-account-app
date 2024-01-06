package net.ahmed.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.ahmed.accountservice.enums.AccountType;
import net.ahmed.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Entity
public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;

    private String currency;
    @Enumerated(EnumType.ORDINAL)
    private AccountType accountType;

    private Long customerId;

    @Transient
    private Customer customer;
}
