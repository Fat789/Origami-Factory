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

import sopra.promo404.origami.model.Etape;
import sopra.promo404.origami.model.Views;
import sopra.promo404.origami.repository.IRepoEtape;

@RestController
@RequestMapping("/etape")
public class EtapeRestController {

	@Autowired
	private IRepoEtape etapeRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewEtape.class)
	public List<Etape> list() {
		return etapeRepo.findAllEtape();
	}

	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewEtapeWithOrigami.class)
	public Etape detail(@PathVariable Long id) {
		return etapeRepo.findEtapeByIdWithOrigami(id);
	}

	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewEtape.class)
	public Etape add(@RequestBody Etape etape) {
		etapeRepo.save(etape);

		return etape;
	}

	@PutMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewEtape.class)
	public Etape edit(@RequestBody Etape etape, @PathVariable Long id) {
		etapeRepo.save(etape);

		return (Etape) etapeRepo.findById(id).get();
	}

	@DeleteMapping("/{id}")
	@JsonView(Views.ViewEtape.class)
	public void delete(@PathVariable Long id) {
		etapeRepo.deleteById(id);
	}
}