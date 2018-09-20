package sopra.promo404.origami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.promo404.origami.model.Medecin;
import sopra.promo404.origami.model.Views;
import sopra.promo404.origami.repository.IRepoMedecin;



@RestController
@RequestMapping("/medecin")
public class MedecinRestController {

	@Autowired
	private IRepoMedecin medecinRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewMedecin.class)
	public List<Medecin> list() {
		return medecinRepo.findAllMedecin();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewMedecinWithSpecialite.class)
	public Medecin detail(@PathVariable Long id) {
		return medecinRepo.findMedecinByIdWithSpecialite(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewMedecin.class)
	public Medecin add(@RequestBody Medecin medecin) {
		medecinRepo.save(medecin);

		return medecin;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewMedecin.class)
	public Medecin edit(@RequestBody Medecin medecin, @PathVariable Long id) {
		medecinRepo.save(medecin);

		return (Medecin) medecinRepo.findById(id).get();
	}


	@DeleteMapping("/{id}")
	@JsonView(Views.ViewMedecin.class)
	public void delete(@PathVariable Long id) {
		medecinRepo.deleteById(id);
	}

}
