package eu.ensup.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.ensup.domaine.Adresse;
import eu.ensup.domaine.Magasin;

@Repository
public interface MagasinRepository extends JpaRepository<Magasin, Long>{

	public List<Magasin> findMagasinsByAdresse(Adresse adresse);
}
