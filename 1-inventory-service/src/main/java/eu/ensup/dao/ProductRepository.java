package eu.ensup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.domaine.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
