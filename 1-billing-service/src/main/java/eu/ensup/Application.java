package eu.ensup;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import eu.ensup.dao.BillRepository;
import eu.ensup.dao.ProductItemRepository;
import eu.ensup.domaine.Bill;
import eu.ensup.domaine.Customer;
import eu.ensup.domaine.Product;
import eu.ensup.domaine.ProductItem;
import eu.ensup.service.CustomerService;
import eu.ensup.service.InventoryService;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start2(
			BillRepository billRepository,
			ProductItemRepository productItemRepository,
			CustomerService customerService,
			InventoryService inventoryService
			) 
	{
		
		return args -> {
			// afficher un client connaissant son id
			Customer customer = customerService.findCustomerById(1L);
			Customer customer2 = customerService.findCustomerById(2L);
			System.out.println("Information du client");
			System.out.println("*****************************************");
			System.out.println(customer.getId());
			System.out.println(customer.getEmail());
			System.out.println(customer.getNom() );
			System.out.println(customer.getPrenom());
			System.out.println("*****************************************");
			
			// afficher un client connaissant son id
			Product product = inventoryService.findProductById(1L);
			Product product2 = inventoryService.findProductById(2L);
			System.out.println("Information du produit");
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			System.out.println("*****************************************");
			
			// Créer un facture
			Bill bill1 = new Bill();
			bill1.setBillingDate(new Date());
			bill1.setCustomerId(customer.getId());
			billRepository.save(bill1);
			
			// Créer un deuxième facture
			Bill bill2 = new Bill();
			bill2.setBillingDate(new Date());
			bill2.setCustomerId(customer2.getId());
			billRepository.save(bill2);
			
			// ajouter les produits à la facture
			ProductItem productItem = new ProductItem();
			productItem.setBill(bill1);
			productItem.setPrice(product.getPrice());
			productItem.setQuantity(1);
			productItem.setProductID(product.getId());
			productItemRepository.save(productItem);
			
			// ajouter les produits à la facture2
			ProductItem productItem2 = new ProductItem();
			productItem2.setBill(bill2);
			productItem2.setPrice(product2.getPrice());
			productItem2.setQuantity(1);
			productItem2.setProductID(product2.getId());
			productItemRepository.save(productItem2);
//			ProductItem productItem = new ProductItem();
//			productItem.setId(product.getId());
//			productItem.setQuantity(10);
//			productItem.setPrice(product.getPrice());
//			
//			bill1.getProductItems().add(productItem);
			
			System.out.println("***********Création facture************");
		};
		
	}
}
