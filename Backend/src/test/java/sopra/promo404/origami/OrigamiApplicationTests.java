package sopra.promo404.origami;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

		etapeRepo.save(e1);

		Etape e2 = new Etape();
		e2.setNumeroEtape(2);
		e2.setDescription(null);
		e2.setImageEtape(null);

		etapeRepo.save(e2);

		Etape e3 = new Etape();
		e3.setNumeroEtape(3);
		e3.setDescription(null);
		e3.setImageEtape(null);

		etapeRepo.save(e3);

		Etape e4 = new Etape();
		e4.setNumeroEtape(4);
		e4.setDescription(null);
		e4.setImageEtape(null);

		etapeRepo.save(e4);

		// Listes d'étapes creation

		List<Etape> etapes1 = new ArrayList<>();
		etapes1.add(e1);
		etapes1.add(e2);

		etapeRepo.saveAll(etapes1);

		List<Etape> etapes2 = new ArrayList<>();
		etapes2.add(e1);
		etapes2.add(e2);
		etapes2.add(e3);
		etapes2.add(e4);

		etapeRepo.saveAll(etapes2);

		List<Etape> etapes3 = new ArrayList<>();
		etapes3.add(e3);
		etapes3.add(e4);

		etapeRepo.saveAll(etapes3);

		// Image Origami creation

		// Admin creation

		Admin carlotta = new Admin();
		carlotta.setUsername("CarlottaFlantier");
		carlotta.setPassword("wagonLit");

		adminRepo.save(carlotta);

		Admin dolores = new Admin();
		dolores.setUsername("DoloresDelabatte");
		dolores.setPassword("litCouchette");

		adminRepo.save(dolores);

		// Origami creation

		Origami ori1 = new Origami();

		ori1.setNom("Origami 1");
		ori1.setTempsRea("30 minutes");
		ori1.setNbFeuille(5);
		ori1.setNiveau(Niveau.facile);
		ori1.setNote(2);
		ori1.setEtapes(etapes1);
		ori1.setImageOri(
				"https://upload.wikimedia.org/wikipedia/en/thumb/b/b6/Dramatic_Chipmunk.png/220px-Dramatic_Chipmunk.png");
		ori1.setYoutube("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		ori1.setActif(true);

		origamiRepo.save(ori1);

		Origami ori2 = new Origami();

		ori2.setNom("Origami 2");
		ori2.setTempsRea("1 heure");
		ori2.setNbFeuille(12);
		ori2.setNiveau(Niveau.moyen);
		ori2.setNote(8);
		ori2.setEtapes(etapes2);
		ori2.setImageOri(
				"https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Doge_homemade_meme.jpg/220px-Doge_homemade_meme.jpg");
		ori2.setYoutube("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		ori2.setActif(true);

		origamiRepo.save(ori2);
		
		

		// Categorie creation
		// SuperCats creation
		Categorie supercat1 = new Categorie();
		supercat1.setNom("Animal");
		supercat1.setSuperCat(null);
		supercat1.setOrigamis(null);

		categorieRepo.save(supercat1);
		
		supercat1.setNom("Animaux");
		categorieRepo.save(supercat1);

		// Liste Origami pour la categorie 1
		List<Origami> listOrigamiCat1 = new ArrayList<>();
		listOrigamiCat1.add(ori1);

		origamiRepo.saveAll(listOrigamiCat1);

		// Liste Origami pour la categorie 1
		List<Origami> listOrigamiCat2 = new ArrayList<>();
		listOrigamiCat2.add(ori2);

		origamiRepo.saveAll(listOrigamiCat2);

		Categorie cat1 = new Categorie();
		cat1.setNom("Oiseaux");
		cat1.setSuperCat(supercat1);
		cat1.setOrigamis(listOrigamiCat1);

		categorieRepo.save(cat1);

		Categorie cat2 = new Categorie();
		cat2.setNom("Reptiles");
		cat2.setSuperCat(supercat1);
		cat2.setOrigamis(listOrigamiCat2);

		categorieRepo.save(cat2);

		List<Categorie> superCats1 = new ArrayList<>();
		superCats1.add(cat1);
		superCats1.add(cat2);

		categorieRepo.saveAll(superCats1);

	}
}
