package sopra.promo404.origami.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.promo404.origami.model.Origami;

public interface IRepoOrigami extends JpaRepository<Origami, Long>{
	@Query("select o from Origami o")
	List<Origami> findAllOrigami();
	
	@Query("select distinct o from Origami o left join fetch o.etapes e where o.id= :id")
	Origami findOrigamiWithEtapes(@Param("id") Long id);
	
}
