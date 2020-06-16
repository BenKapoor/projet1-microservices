package eu.ensup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.dao.CustomerRepository;
import eu.ensup.domaine.Customer;

@Service
public class ServiceImpl implements Iservice {

	@Autowired
	CustomerRepository dao;
	
	@Override
	public void addCutomer(Customer c) {
		// TODO Auto-generated method stub
		dao.save(c);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}
}
