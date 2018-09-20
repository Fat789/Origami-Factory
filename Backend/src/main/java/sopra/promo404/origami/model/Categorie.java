package sopra.promo404.origami.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Categorie {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private long id;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private Categorie superCat;
	@JsonView(Views.ViewCategorie.class)
	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	private List<Origami> origamis;

	public Categorie() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getSuperCat() {
		return superCat;
	}

	public void setSuperCat(Categorie superCat) {
		this.superCat = superCat;
	}

	public List<Origami> getOrigamis() {
		return origamis;
	}

	public void setOrigamis(List<Origami> origamis) {
		this.origamis = origamis;
	}

}
