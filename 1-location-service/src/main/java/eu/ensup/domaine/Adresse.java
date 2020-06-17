package eu.ensup.domaine;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numRue;
	private String nomRue;
	private String codePostal;
	private String ville;
	
	@OneToMany(mappedBy = "adresse")
	private Collection<Magasin> magasins = new ArrayList<Magasin>();
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adresse(String numRue, String nomRue, String codePostal, String ville, Collection<Magasin> magasins) {
		super();
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.magasins = magasins;
	}
	
	public Adresse(Long id, String numRue, String nomRue, String codePostal, String ville) {
		super();
		this.id = id;
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	public Adresse(String numRue, String nomRue, String codePostal, String ville) {
		super();
		this.numRue = numRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Collection<Magasin> getMagasins() {
		return magasins;
	}

	public void setMagasins(Collection<Magasin> magasins) {
		this.magasins = magasins;
	}
}
