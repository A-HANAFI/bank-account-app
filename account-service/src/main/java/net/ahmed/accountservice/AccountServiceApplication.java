package net.ahmed.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}



//	@Bean
//	CommandLineRunner commandLineRunner(AccountRepository accountRepository,
//										CustomerRestClient theCustomerRestClient){
//		return  args -> {
//			theCustomerRestClient.findAll().forEach(
//					customer -> {
//			List<BankAccount> accountList = List.of(
//					BankAccount.builder()
//							.accountId(UUID.randomUUID().toString())
//							.accountType(AccountType.SAVING_ACCOUNT)
//							.currency("TND")
//							.balance(Math.random())
//							.createdAt(LocalDate.now())
//							.customerId(Long.valueOf(customer.getId()))
//							.build(),
//					BankAccount.builder()
//							.accountId(UUID.randomUUID().toString())
//							.accountType(AccountType.SAVING_ACCOUNT)
//							.currency("TND")
//							.balance(Math.random())
//							.createdAt(LocalDate.now())
//							.customerId(Long.valueOf(customer.getId()))
//							.build()
//			);
//				accountRepository.saveAll(accountList);
//					}
//			);
//
//		};
//	}
}
