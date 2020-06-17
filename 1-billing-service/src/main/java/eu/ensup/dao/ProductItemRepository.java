package eu.ensup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.domaine.Bill;
import eu.ensup.domaine.ProductItem;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{

	public List<ProductItem> findProductItemByBill(Bill bill);
}
