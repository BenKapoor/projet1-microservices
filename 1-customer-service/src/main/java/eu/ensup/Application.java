package eu.ensup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.ensup.dao.CustomerRepository;
import eu.ensup.domaine.Customer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer("huios","eddy","eddy@huios.com")); 
			customerRepository.save(new Customer("test","elise","elise@huios.com"));
			customerRepository.save(new Customer("Bernard","shirel","shirel@huios.com"));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
