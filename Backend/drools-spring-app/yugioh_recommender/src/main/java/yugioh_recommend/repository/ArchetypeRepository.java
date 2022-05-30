package yugioh_recommend.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import yugioh_recommend.model.Archetype;

public interface ArchetypeRepository extends JpaRepository<Archetype, UUID>{

}
