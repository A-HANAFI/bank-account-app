package net.ahmed.customerservice;

import net.ahmed.customerservice.entities.Customer;
import net.ahmed.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
//@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner	(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList = List.of(
					Customer.builder()
							.FirstName("salah")
							.LastName("matoui")
							.email("brahim@test.com")
							.build(),
					Customer.builder()
							.FirstName("ali")
							.LastName("karoui")
							.email("brahim@test.com")
							.build(),
					Customer.builder()
							.FirstName("farouk")
							.LastName("maatalli")
							.email("farouk@test.com")
							.build()
			);

			customerRepository.saveAll(customerList);

		};
	};

}
