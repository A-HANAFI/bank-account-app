package net.ahmed.accountservice.repositories;

import net.ahmed.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
    List<BankAccount> findBankAccountsByCustomerId(Long id);
}
