package eu.ensup.service;

import java.util.List;

import eu.ensup.domaine.Product;

public interface Iservice {

	public void addProduit(Product p);
	public List<Product> findAll(); 
	public Product getProduit(Long id);
}
