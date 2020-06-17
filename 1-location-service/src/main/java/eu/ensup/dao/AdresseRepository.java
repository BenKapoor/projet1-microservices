package eu.ensup.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.domaine.Adresse;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Long>{

}
