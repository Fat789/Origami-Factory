package sopra.promo404.origami.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.promo404.origami.model.Origami;

public interface IRepoOrigami extends JpaRepository<Origami, Long>{
	@Query("select o from Origami o where o.id= :id")
	List<Origami> findAllAdmin();
}
