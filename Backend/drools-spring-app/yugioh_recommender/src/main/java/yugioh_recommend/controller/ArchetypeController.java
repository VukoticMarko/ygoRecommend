package yugioh_recommend.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import yugioh_recommend.dto.ArchetypeRequest;
import yugioh_recommend.dto.ArchetypeResponse;
import yugioh_recommend.service.ArchetypeService;

@RestController
@RequestMapping("/api/archetypes")
public class ArchetypeController {
	
    @Autowired
    private ArchetypeService archetypeService;

    @RequestMapping(method=RequestMethod.GET, produces = "application/json")
    public List<ArchetypeResponse> getAll() {
        return archetypeService.getAll();
    }

    @GetMapping("/{id}")
    public ArchetypeResponse getOne(@PathVariable UUID id) {
        return archetypeService.getOne(id);
    }

    @PostMapping
    public UUID create(@RequestBody ArchetypeRequest ar) {
        return archetypeService.create(ar);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ArchetypeRequest pr, @PathVariable UUID id) {
    	archetypeService.update(pr, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
    	archetypeService.delete(id);
    }

    @PostMapping("/recommend")
    public List<ArchetypeResponse> recommend(@RequestBody ArchetypeRequest ar) {
        return archetypeService.recommend(ar);
    }
   
}