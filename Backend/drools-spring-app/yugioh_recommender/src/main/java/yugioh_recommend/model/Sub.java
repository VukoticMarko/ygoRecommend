package yugioh_recommend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;


@Entity(name = "sub")
public class Sub { // Associative
	
	@Id
    @Column(name = "id", columnDefinition = "varchar(36)")
    @Type(type = "uuid-char")
	private UUID id;
	
	
	@Column(name = "sub_type")
	@Enumerated(EnumType.STRING)
	private SubType subType;
	
	
	@Column(name = "difficulty")
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;  // Easy (1-3), Medium (4-6), Hard (7-9), Master (10-12) 
	
	@ManyToMany(mappedBy="subs")
	private List<Archetype> archetypes;
	
	public Difficulty convertDifficulty(int diff) {
		if(diff > 0 && diff <= 3) {
			return Difficulty.Easy;
		}else if(diff >= 4 && diff <= 6) {
			return Difficulty.Medium;
		}else if(diff >= 7 && diff <= 9) {
			return Difficulty.Hard;
		}else return Difficulty.Master;
	}

	public Sub() {
		
	}
	
	public Sub(UUID id, SubType subType, Difficulty difficulty) {
		super();
		this.id = id;
		this.subType = subType;
		this.difficulty = difficulty;
	}

	// When creating archetype
	public Sub(SubType subType, int difficulty) {
		super();
		this.subType = subType;
		this.difficulty = convertDifficulty(difficulty);
	}

	public List<Archetype> getArchetypes() {
		return archetypes;
	}

	public void setArchetypes(List<Archetype> archetypes) {
		this.archetypes = archetypes;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public SubType getSubType() {
		return subType;
	}

	public void setSubType(SubType subType) {
		this.subType = subType;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	
	
}
