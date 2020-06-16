package eu.ensup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.domaine.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
