package service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.ArchetypeRequest;
import dto.ArchetypeResponse;
import model.Archetype;
import model.SubType;
import repository.ArchetypeRepository;

@Service
public class ArchetypeService {
	
	private static Logger log = LoggerFactory.getLogger(ArchetypeService.class);
    private final KieContainer kieContainer;
    @Autowired
    private ArchetypeRepository archetypeRepository;
	
    @Autowired
    public  ArchetypeService(KieContainer kieContainer, ArchetypeRepository archetypeRepository) {
        log.info("Initialising a new example session.");
        this.kieContainer = kieContainer;
        this.archetypeRepository = archetypeRepository;
    }
    
	public List<ArchetypeResponse> getAll() {
        List<Archetype> archs = archetypeRepository.findAll();
        List<ArchetypeResponse> archetypeResponseList = new ArrayList<ArchetypeResponse>();
        archs.forEach(arch -> archetypeResponseList.add(new ArchetypeResponse(arch)));
        return archetypeResponseList;
    }

    public ArchetypeResponse getOne(UUID id) {
        Optional<Archetype> maybeArchetype = archetypeRepository.findById(id);
        if(maybeArchetype.isEmpty()) {
            throw new EntityNotFoundException("Archetype with the id " + id.toString() + " does not exist.");
        }
        return new ArchetypeResponse(maybeArchetype.get());
    }
    
    public UUID create(ArchetypeRequest archetype) {
		UUID id = UUID.randomUUID();
		
		Archetype arch = new Archetype(
				id, 
				archetype.getName(),
				archetype.getDescription(),
				archetype.getHowToPlay(),
				archetype.getMainTypeOfDeck(),
				archetype.getChosenTypes(),
				//archetype.getChosenSubTypes(),
				archetype.getChosenDifficulty(),
				archetype.getDifficulty(),
				archetype.getChosenExtraDeckMechanics(),
				archetype.getChosenPlaystyle(),
				archetype.getAttribute(),
				archetype.getKeywords()
				);
		archetypeRepository.save(arch);
		return id;
	}


	public void update(ArchetypeRequest archetype, UUID id) {
		Optional<Archetype> maybeArchetype = archetypeRepository.findById(id);
		if(maybeArchetype.isEmpty()) {
			throw new EntityNotFoundException("Archetype with the id " + id.toString() + " does not exist.");
		}
		
		/*
		 * Archetype arch = new Archetype( id, archetype.get );
		 */
		//archetypeRepository.save(arch);
	}


	public void delete(UUID id) {
		Optional<Archetype> maybeArchetype = archetypeRepository.findById(id);
		if(maybeArchetype.isEmpty()) {
			throw new EntityNotFoundException("Archetype with the id " + id.toString() + " does not exist.");
		}
		archetypeRepository.deleteById(maybeArchetype.get().getId());
	}

	
}
