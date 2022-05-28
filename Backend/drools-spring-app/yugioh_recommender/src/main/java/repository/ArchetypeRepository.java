package repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Archetype;

public interface ArchetypeRepository extends JpaRepository<Archetype, UUID>{

}
