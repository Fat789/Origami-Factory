package sopra.promo404.origami;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sopra.promo404.origami.model.Admin;
import sopra.promo404.origami.model.Categorie;
import sopra.promo404.origami.model.Etape;
import sopra.promo404.origami.model.Niveau;
import sopra.promo404.origami.model.Origami;
import sopra.promo404.origami.repository.IRepoAdmin;
import sopra.promo404.origami.repository.IRepoCategorie;
import sopra.promo404.origami.repository.IRepoEtape;
import sopra.promo404.origami.repository.IRepoOrigami;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrigamiApplicationTests {

	@Autowired
	private IRepoAdmin adminRepo;
	@Autowired
	private IRepoCategorie categorieRepo;
	@Autowired
	private IRepoEtape etapeRepo;
	@Autowired
	private IRepoOrigami origamiRepo;

	@Test
	public void contextLoads() throws ParseException {

		// Etape creation
		
		Etape e1 = new Etape();
		e1.setNumeroEtape(1);
		e1.setDescription(null);
		e1.setImageEtape(null);
		e1.setOrigami(ori1);
		
		etapeRepo.save(e1);
		
		Etape e2 = new Etape();
		e2.setNumeroEtape(2);
		e2.setDescription(null);
		e2.setImageEtape(null);
		e2.setOrigami(ori2);
		
		etapeRepo.save(e2);
		
		// Origami creation

		Origami ori1 = new Origami();

		ori1.setNom("avion1");
		ori1.setTempsRea(null);
		ori1.setNbFeuille(5);
		ori1.setNiveau(Niveau.facile);
		ori1.setNote(0);
		ori1.setEtapes(null);
		ori1.setImageOri(null);
		ori1.setYoutube(null);
		ori1.setCategories(null);
		ori1.setActif(true);

		origamiRepo.save(ori1);

		Origami ori2 = new Origami();

		ori2.setNom("avion2");
		ori2.setTempsRea(null);
		ori2.setNbFeuille(12);
		ori2.setNiveau(Niveau.moyen);
		ori2.setNote(8);
		ori2.setEtapes(null);
		ori2.setImageOri(null);
		ori2.setYoutube(null);
		ori2.setCategories(null);
		ori2.setActif(true);

		origamiRepo.save(ori2);

		// Admin creation

		Admin carlotta = new Admin();
		carlotta.setUsername("CarlottaFlantier");
		carlotta.setPassword("wagonLit");

		adminRepo.save(carlotta);

		Admin dolores = new Admin();
		dolores.setUsername("DoloresDelabatte");
		dolores.setPassword("litCouchette");

		adminRepo.save(dolores);

		// Categorie creation

		Categorie cat1 = new Categorie();
		cat1.setNom("Avion de chasse");
		cat1.setSuperCat(null);
		cat1.setSuperCats(null);
		cat1.setOrigamis(null);

		categorieRepo.save(cat1);

		Categorie cat2 = new Categorie();
		cat2.setNom("Avion de merde");
		cat2.setSuperCat(null);
		cat2.setSuperCats(null);
		cat2.setOrigamis(null);

		categorieRepo.save(cat2);


		

	}
}
