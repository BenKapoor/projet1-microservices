package eu.ensup.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import eu.ensup.domaine.Customer;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerService {

	@GetMapping("/customers/getAll/{id}")
	public Customer findCustomerById(@PathVariable(name="id")Long id);
	
}
