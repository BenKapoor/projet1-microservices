package eu.ensup.service;

import java.util.List;

import eu.ensup.domaine.Bill;

public interface IBillService {
	public Bill getBill(Long id);
	
	public List<Bill> findAllBills();

}
