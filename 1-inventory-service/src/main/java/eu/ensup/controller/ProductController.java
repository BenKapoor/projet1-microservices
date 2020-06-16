package eu.ensup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.domaine.Product;
import eu.ensup.service.Iservice;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	Iservice service;
	
	@GetMapping(value = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Product> listProducts() {
		return service.findAll();
	}
	
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody Product product) {
		service.addProduit(product);
	}
	
	@GetMapping(value = "/getAll/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Product getProduct(@PathVariable("id") Long id) {
		return service.getProduit(id);
	}

}
