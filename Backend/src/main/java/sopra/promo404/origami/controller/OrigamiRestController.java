package sopra.promo404.origami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import sopra.promo404.origami.model.Origami;
import sopra.promo404.origami.model.Views;
import sopra.promo404.origami.repository.IRepoOrigami;

@CrossOrigin("*")
@RestController
@RequestMapping("/origami")
public class OrigamiRestController {

		@Autowired
		private IRepoOrigami origamiRepo;

		@GetMapping("")
		@ResponseBody
		@JsonView(Views.ViewOrigami.class)
		public List<Origami> list() {
			return origamiRepo.findAllOrigami();
		}

		@GetMapping("/{id}")
		@ResponseBody
		@JsonView(Views.ViewOrigamiWithEtapes.class)
		public Origami detail(@PathVariable Long id) {
			return origamiRepo.findOrigamiWithEtapes(id);
		}

		@PostMapping("")
		@ResponseBody
		@JsonView(Views.ViewOrigami.class)
		public Origami add(@RequestBody Origami origami) {
			origamiRepo.save(origami);

			return origami;
		}

		@PutMapping("/{id}")
		@ResponseBody
		@JsonView(Views.ViewOrigami.class)
		public Origami edit(@RequestBody Origami origami, @PathVariable Long id) {
			origamiRepo.save(origami);

			return (Origami) origamiRepo.findById(id).get();
		}


		@DeleteMapping("/{id}")
		@JsonView(Views.ViewOrigami.class)
		public void delete(@PathVariable Long id) {
			origamiRepo.deleteById(id);
		}
}
