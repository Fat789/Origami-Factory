package sopra.promo404.origami.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="categorie")
public class Categorie {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@JsonView(Views.ViewCommon.class)
	private String nom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categorie_id")
	@JsonView(Views.ViewCommon.class)
	private Categorie superCat;

	@OneToMany(mappedBy = "superCat")
	@JsonView(Views.ViewCategorieDetail.class)
	private List<Categorie> superCats;

	
	@ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
	@JsonView(Views.ViewCategorie.class)
	private List<Origami> origamis;

	public Categorie() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Categorie> getSuperCats() {
		return superCats;
	}

	public void setSuperCats(List<Categorie> superCats) {
		this.superCats = superCats;
	}

	public List<Origami> getOrigamis() {
		return origamis;
	}

	public void setOrigamis(List<Origami> origamis) {
		this.origamis = origamis;
	}

}
