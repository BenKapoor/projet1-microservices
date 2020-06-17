package eu.ensup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.ensup.domaine.Magasin;
import eu.ensup.service.IAdresseService;
import eu.ensup.service.IMagasinService;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	IAdresseService adresseService;
	
	@Autowired
	IMagasinService magasinService;
	
	@GetMapping(value = "getAll", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Magasin> listProduct(){
		return magasinService.findAllMagasins();
	}
	
	/**
	 * @param id
	 * @return
	 * 
	 * retourn tous les magasins liés à une adresse (id de l'adresse)
	 */
	@GetMapping(value = "getAll/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Magasin> getMagasin(@PathVariable("id") Long id) {
		
		return magasinService.findMagasinsByAdresse(adresseService.getAdresse(id));
		
	}
}
