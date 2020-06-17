package eu.ensup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eu.ensup.domaine.Adresse;
import eu.ensup.domaine.Magasin;
import eu.ensup.service.AdresseService;
import eu.ensup.service.MagasinService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner start(
			AdresseService adresseService,
			MagasinService magasinService
			) 
	{
		return args -> {
			Adresse adresse = new Adresse();
			adresse.setCodePostal("15");
			adresse.setNomRue("Rue Victor Hugo");
			adresse.setNumRue("76230");
			adresse.setVille("Paris");
			adresseService.addAdresse(adresse);
			
			Adresse adresse2 = new Adresse();
			adresse2.setCodePostal("4");
			adresse2.setNomRue("Rue du Gen De Gaulle");
			adresse2.setNumRue("43678");
			adresse2.setVille("Ailleurs");
			adresseService.addAdresse(adresse2);
			
			Magasin magasin1 = new Magasin();
			magasin1.setNom("IKEA");
			magasin1.setAdresse(adresse);
			magasinService.addMagasin(magasin1);
			
			Magasin magasin2 = new Magasin();
			magasin2.setNom("Monoprix");
			magasin2.setAdresse(adresse);
			magasinService.addMagasin(magasin2);
			
			Magasin magasin3 = new Magasin();
			magasin3.setNom("Carrefour");
			magasin3.setAdresse(adresse2);
			magasinService.addMagasin(magasin3);
		};
	}

}
