package yugioh_recommend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yugioh_recommend.dto.ArchetypeRequest;
import yugioh_recommend.dto.ArchetypeResponse;
import yugioh_recommend.dto.SubResponse;
import yugioh_recommend.facts.Facts;
import yugioh_recommend.model.Archetype;
import yugioh_recommend.model.Sub;
import yugioh_recommend.model.SubType;
import yugioh_recommend.repository.ArchetypeRepository;

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
        List<Archetype> archs = archetypeRepository.findAllWithSubtypes();
        List<ArchetypeResponse> archetypeResponseList = new ArrayList<ArchetypeResponse>();
        archs.forEach(arch -> archetypeResponseList.add(new ArchetypeResponse(arch)));
        for (ArchetypeResponse archetypeResponse : archetypeResponseList) {
			archetypeResponse.initHelpingList(archetypeResponse.getSubs());
			archetypeResponse.setDeckDifficulty(archetypeResponse.convertDifficulty(archetypeResponse.getDeckDifficultyInt()));
		}
        return archetypeResponseList;
    }

    public ArchetypeResponse getOne(UUID id) {
        Optional<Archetype> maybeArchetype = archetypeRepository.findOneWithSubtypes(id);
        if(maybeArchetype.isEmpty()) {
            throw new EntityNotFoundException("Archetype with the id " + id.toString() + " does not exist.");
        }
        return new ArchetypeResponse(maybeArchetype.get());
    }
    
    public UUID create(ArchetypeRequest archetype) {
		UUID id = UUID.randomUUID();
		
//		Archetype arch = new Archetype(
//				id, 
//				archetype.getName(),
//				archetype.getDescription(),
//				archetype.getHowToPlay(),
//				archetype.getMainTypeOfDeck(),
//				archetype.getChosenTypes(),
//				//archetype.getChosenSubTypes(),
//				archetype.getChosenDifficulty(),
//				archetype.getDifficulty(),
//				archetype.getChosenExtraDeckMechanics(),
//				archetype.getChosenPlaystyle(),
//				archetype.getAttribute(),
//				archetype.getKeywords()
//				);
//		archetypeRepository.save(arch);
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
	
	public List<ArchetypeResponse> recommend(ArchetypeRequest areq) {
		
		// TODO: SREDI NULL SLUCAJEVE, AKO KORISNIK NE UNESE NESTO
		
		areq.countTypes(); // Help function for later bonus scoring
		
		Facts fact = new Facts();
		
		KieSession kieSession = kieContainer.newKieSession();
		
		// List of all archetypes that we will filter with scoring
		List<ArchetypeResponse> respList = new ArrayList<ArchetypeResponse>();
		respList = getAll();
		
		// Chosen difficulty by user checker:
		// This will update request and we will use that update for scoring later
		// This rule has direct impact on subtype_difficulty_chain
		kieSession.getAgenda().getAgendaGroup("determine_difficulty").setFocus();
		kieSession.insert(areq);
		kieSession.fireAllRules();
		
		// Next up is checking user's selected difficulty and arthetype's difficulty
		// We will score archetypes with selected difficulties
		kieSession.getAgenda().getAgendaGroup("determine_difficulty_score").setFocus();
		kieSession.insert(areq);
		fact.setArList(respList);
		kieSession.insert(fact);
		kieSession.fireAllRules();
		respList = fact.getArList();
		
		// Now with help of chosen difficulty we will see
		// SubTypes that are that difficult and we will score them
		kieSession.getAgenda().getAgendaGroup("subtype_difficulty_chain").setFocus();
		for (ArchetypeResponse aresp : respList) {			
			kieSession.insert(areq);
			kieSession.insert(aresp);
		}
		kieSession.fireAllRules();
		
		// Now, we will score the number of types that user chose vs the number that archetype has
		// First we will count number of types in each archetype
		// Second we will score archetypes with amount of user's selected types
		kieSession.getAgenda().getAgendaGroup("type_rules").setFocus();
		for (ArchetypeResponse aresp : respList) {			
			kieSession.insert(areq);
			kieSession.insert(aresp);
		}
		kieSession.fireAllRules();
		
		// It's time for extra-deck options
		// We score archetypes based on how many user's extra-deck options they have
		// If archetype has all extra-deck types that user chose, that archetype gets bonus!
		kieSession.getAgenda().getAgendaGroup("extra_deck_rules").setFocus();
		for (ArchetypeResponse aresp : respList) {			
			kieSession.insert(areq);
			kieSession.insert(aresp);
		}
		kieSession.fireAllRules();
		
		return respList;
	}
	
}