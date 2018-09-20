package sopra.promo404.origami.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.promo404.origami.model.Admin;

public interface IRepoAdmin extends JpaRepository<Admin, Long>{
	@Query("select a from Admin a where a.id= :id")
	List<Admin> findAllAdmin();
}
