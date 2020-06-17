package eu.ensup.service;

import java.util.List;

import eu.ensup.domaine.ProductItem;

public interface IProductItemService {

	public ProductItem getProductItem(Long id);
	
	public List<ProductItem> findAllProductItems();
	
	public List<ProductItem> finProductItemsByBills(Long id);
}
