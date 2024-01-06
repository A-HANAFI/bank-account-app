package net.ahmed.accountservice.web;

import net.ahmed.accountservice.clients.CustomerRestClient;
import net.ahmed.accountservice.entities.BankAccount;
import net.ahmed.accountservice.model.Customer;
import net.ahmed.accountservice.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    @Autowired
    public AccountRestController(AccountRepository accountRepository, CustomerRestClient customerRestClient) {
        this.accountRepository = accountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        List<BankAccount> accountList = accountRepository.findAll();
         accountList.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClient.findCustomerById(bankAccount.getCustomerId()));
        });
         return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccount(@PathVariable String id){
        BankAccount account =   accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(account.getCustomerId());
        account.setCustomer(customer);
        return account;
    }

    @GetMapping("/accountsById/{id}")
    public List<BankAccount> getAccountsByCustomerId(@PathVariable Long id){
        return accountRepository.findBankAccountsByCustomerId(id);
    }

}
