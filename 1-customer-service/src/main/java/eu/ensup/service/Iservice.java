package eu.ensup.service;

import java.util.List;

import eu.ensup.domaine.Customer;

public interface Iservice {

	public void addCutomer(Customer c);
	public List<Customer> findAll();
	public Customer findById(Long id);
}	

