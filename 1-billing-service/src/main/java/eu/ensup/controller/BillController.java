package eu.ensup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.domaine.Bill;
import eu.ensup.service.CustomerService;
import eu.ensup.service.IBillService;
import eu.ensup.service.IProductItemService;
import eu.ensup.service.InventoryService;

@RestController
@RequestMapping("/bills")
public class BillController {

	@Autowired
	IBillService billService;
	
	@Autowired
	IProductItemService productItemService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping(value = "fullBill/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Bill getBill(@PathVariable("id") Long id) {
		// on récupère les factures
		Bill bill = billService.getBill(id);
		// on récupère toutes les infos du customer dans la facture
		bill.setCustomer(customerService.findCustomerById(bill.getCustomerId()));
		// récupérations des produits contenus dans la facture
		bill.setProductItems(productItemService.finProductItemsByBills(bill.getId()));
		bill.getProductItems().forEach(producItems -> {
			producItems.setProduct(inventoryService.findProductById(producItems.getProductID()));
		});
		return bill;
	}
}
