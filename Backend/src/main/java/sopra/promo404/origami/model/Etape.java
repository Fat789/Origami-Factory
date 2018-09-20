package sopra.promo404.origami.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.origami.model.Views;

@Entity
@Table(name = "etape")
public class Etape {

	@Id
	@GeneratedValue
	@Column(name = "etape_id")
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@Column(name = "numero_etape")
	@JsonView(Views.ViewCommon.class)
	private int numeroEtape;
	@Column(name = "description")
	@JsonView(Views.ViewCommon.class)
	private String description;
	@Column(name = "image_etape")
	@JsonView(Views.ViewCommon.class)
	private String imageEtape;
	@JsonView(Views.ViewCommon.class)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name= "origami_id")
	private Origami origami;
	
	
		
	public Etape() {
		super();
	}
	
	
	public Etape(Long id, int numeroEtape, String description, String imageEtape, Origami origami) {
		super();
		this.id = id;
		this.numeroEtape = numeroEtape;
		this.description = description;
		this.imageEtape = imageEtape;
		this.origami = origami;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroEtape() {
		return numeroEtape;
	}
	public void setNumeroEtape(int numeroEtape) {
		this.numeroEtape = numeroEtape;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageEtape() {
		return imageEtape;
	}
	public void setImageEtape(String imageEtape) {
		this.imageEtape = imageEtape;
	}
	public Origami getOrigami() {
		return origami;
	}
	public void setOrigami(Origami origami) {
		this.origami = origami;
	}

	

}
