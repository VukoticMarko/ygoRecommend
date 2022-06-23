package yugioh_recommend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import yugioh_recommend.model.Archetype;

@Repository
public interface ArchetypeRepository extends JpaRepository<Archetype, UUID>{
//	@Query(
//			  value = "SELECT a.* FROM archetypes a left join archetype_sub_types_in_deck s on a.id = s.archetype_id left join sub ss on ss.id = s.sub_id", 
//			  nativeQuery = true)
	@Query("SELECT a FROM archetypes a left join fetch a.subs")
	List<Archetype> findAllWithSubtypes();
	
	@Query("SELECT a FROM archetypes a left join fetch a.subs WHERE a.id = :id")
	Optional<Archetype> findOneWithSubtypes(@Param("id") UUID id);
}
