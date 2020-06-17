package eu.ensup.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import eu.ensup.domaine.Product;

@FeignClient(name="INVENTORY-SERVICE")
public interface InventoryService {

	@GetMapping("/products/getAll/{id}")
	public Product findProductById(@PathVariable(name="id")Long id);
	
	@GetMapping("/products/getAll")
	public PagedModel<Product> findAllProducts();
	
}
