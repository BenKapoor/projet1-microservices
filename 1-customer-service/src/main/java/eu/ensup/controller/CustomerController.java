package eu.ensup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import eu.ensup.domaine.Customer;
import eu.ensup.service.Iservice;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	Iservice service;
	
	@GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> listCustomers() {
		return service.findAll();
	}
	
	@PostMapping("/addCustomer")
	public void addCustomer(@RequestBody Customer customer) {
		service.addCutomer(customer);
	}
	
	@GetMapping(value = "/getAll/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomer(@PathVariable("id") Long id) {
		return service.findById(id);
	}
}
