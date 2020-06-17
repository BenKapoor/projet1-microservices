package eu.ensup.service;

import java.util.List;

import eu.ensup.domaine.Adresse;

public interface IAdresseService {

	public Adresse getAdresse(Long id);
	
	public List<Adresse> findAllAdresses();
	
	public void addAdresse(Adresse adresse);
}
