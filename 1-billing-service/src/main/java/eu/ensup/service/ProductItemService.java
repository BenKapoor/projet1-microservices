package eu.ensup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.dao.BillRepository;
import eu.ensup.dao.ProductItemRepository;
import eu.ensup.domaine.Bill;
import eu.ensup.domaine.ProductItem;

@Service
public class ProductItemService implements IProductItemService {

	@Autowired
	ProductItemRepository dao;
	
	@Autowired
	BillRepository daoBill;
	
	@Override
	public ProductItem getProductItem(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public List<ProductItem> findAllProductItems() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public List<ProductItem> finProductItemsByBills(Long id) {
		// TODO Auto-generated method stub
		Bill bill = daoBill.findById(id).get();
		return dao.findProductItemByBill(bill);
	}

}
