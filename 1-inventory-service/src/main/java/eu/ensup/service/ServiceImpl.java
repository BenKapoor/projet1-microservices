package eu.ensup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.dao.ProductRepository;
import eu.ensup.domaine.Product;

@Service
public class ServiceImpl implements Iservice {

	@Autowired
	ProductRepository dao;
	
	@Override
	public void addProduit(Product p) {
		// TODO Auto-generated method stub
		dao.save(p);

	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Product getProduit(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
