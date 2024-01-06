package net.ahmed.customerservice.entities;


import jakarta.persistence.*;
import lombok.*;
import net.ahmed.customerservice.model.BankAccount;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@ToString @Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String FirstName;
    private String LastName;
    private String email;

    @Transient
    private List<BankAccount> bankAccountList;
}
