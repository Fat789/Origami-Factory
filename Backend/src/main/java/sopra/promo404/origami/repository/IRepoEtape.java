package sopra.promo404.origami.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sopra.promo404.origami.model.Etape;

public interface IRepoEtape extends JpaRepository<Etape, Long>{

	@Query("select e from Etape e")
	List<Etape> findAllEtape();
	
	
	@Query("select distinct e from Etape e left join fetch e.origami o where e.id = :id")
	Etape findEtapeByIdWithOrigami(@Param("id") Long id);
	
}
