package yugioh_recommend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yugioh_recommend.model.Sub;

@Repository
public interface SubRepository extends JpaRepository<Sub, UUID>{

}
