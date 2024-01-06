package net.ahmed.customerservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.ahmed.customerservice.model.BankAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(name = "ACCOUNT-SERVICE")
public interface BankAccountRestClient {

    @GetMapping("/accountsById")
    @CircuitBreaker(name="customerService",fallbackMethod = "defaultBankAccountList")
    public List<BankAccount> bankAccountList(@PathVariable Long id);


    default List<BankAccount>  defaultBankAccountList(Exception exception){
        return List.of();
    }
}
