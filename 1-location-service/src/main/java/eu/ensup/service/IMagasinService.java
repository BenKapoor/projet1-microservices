package eu.ensup.service;

import java.util.List;

import eu.ensup.domaine.Adresse;
import eu.ensup.domaine.Magasin;

public interface IMagasinService {
	
	public void addMagasin(Magasin magasin);

	public Magasin getMagasin(Long id);
	
	public List<Magasin> findAllMagasins();
	
	public List<Magasin> findMagasinsByAdresse(Adresse adresse);
}
