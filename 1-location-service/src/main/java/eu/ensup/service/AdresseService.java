package eu.ensup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.dao.AdresseRepository;
import eu.ensup.domaine.Adresse;

@Service
public class AdresseService implements IAdresseService {

	@Autowired
	AdresseRepository daoAdresse;
	
	@Override
	public Adresse getAdresse(Long id) {
		// TODO Auto-generated method stub
		return daoAdresse.findById(id).get();
	}

	@Override
	public List<Adresse> findAllAdresses() {
		// TODO Auto-generated method stub
		return daoAdresse.findAll();
	}

	@Override
	public void addAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		daoAdresse.save(adresse);		
	}

}
