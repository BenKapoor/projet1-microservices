package eu.ensup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.ensup.dao.AdresseRepository;
import eu.ensup.dao.MagasinRepository;
import eu.ensup.domaine.Adresse;
import eu.ensup.domaine.Magasin;

@Service
public class MagasinService implements IMagasinService {

	@Autowired
	MagasinRepository daoMagasin;
	
	@Autowired
	AdresseRepository daoAdresse;
	
	@Override
	public Magasin getMagasin(Long id) {
		// TODO Auto-generated method stub
		return daoMagasin.findById(id).get();
	}

	@Override
	public List<Magasin> findAllMagasins() {
		// TODO Auto-generated method stub
		return daoMagasin.findAll();
	}

	@Override
	public List<Magasin> findMagasinsByAdresse(Adresse adresse) {
		// TODO Auto-generated method stub

		return daoMagasin.findMagasinsByAdresse(adresse);
	}

	@Override
	public void addMagasin(Magasin magasin) {
		// TODO Auto-generated method stub
		daoMagasin.save(magasin);		
	}

}
