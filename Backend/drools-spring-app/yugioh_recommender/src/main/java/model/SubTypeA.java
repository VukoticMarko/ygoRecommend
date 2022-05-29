package model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;

@AllArgsConstructor

@Entity(name = "sub_type_a")
public class SubTypeA { // Associative
	
	@Id
    @Column(name = "id", columnDefinition = "varchar(36)")
    @Type(type = "uuid-char")
	private UUID id;
	
	
	@Column(name = "sub_type")
	@Enumerated(EnumType.STRING)
	private SubType subType;
	
	
	@Column(name = "difficulty")
	@Enumerated(EnumType.STRING)
	private Difficulty difficulty;
	
	public Difficulty convertDifficulty(int diff) {
		if(diff > 0 && diff <= 3) {
			return Difficulty.Easy;
		}else if(diff >= 4 && diff <= 6) {
			return Difficulty.Medium;
		}else if(diff >= 7 && diff <= 9) {
			return Difficulty.Hard;
		}else return Difficulty.Master;
	}

	
	
	public SubTypeA(UUID id, SubType subType, Difficulty difficulty) {
		super();
		this.id = id;
		this.subType = subType;
		this.difficulty = difficulty;
	}

	// When creating archetype
	public SubTypeA(SubType subType, int difficulty) {
		super();
		this.subType = subType;
		this.difficulty = convertDifficulty(difficulty);
	}
	
	
	
}
