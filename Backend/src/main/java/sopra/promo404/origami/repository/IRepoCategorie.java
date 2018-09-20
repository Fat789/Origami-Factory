package sopra.promo404.origami.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.origami.model.Categorie;
import sopra.promo404.origami.model.Origami;

public interface IRepoCategorie extends JpaRepository<Categorie, Long> {
	@Query("select c from Categorie c where c.id= :id")
	List<Categorie> findAllCategorie();

	@Query("select distinct c from Categorie c left join fetch c.origamis o where c.id= :id")
	Origami findCategorieByIdWithOrigami(@Param("id") Long id);
}
