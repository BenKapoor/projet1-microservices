package eu.ensup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("Riz", 12, "riz en poudre"));
			productRepository.save(new Product("Pâte", 2, "Pâte en poudre"));
			productRepository.save(new Product("Pomme", 5, "Pomme en poudre"));
			productRepository.findAll().forEach(System.out::println);
			
		};
	}

}
