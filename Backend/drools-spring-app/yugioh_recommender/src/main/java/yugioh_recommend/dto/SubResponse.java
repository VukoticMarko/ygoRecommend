package yugioh_recommend.dto;

import java.util.UUID;

import yugioh_recommend.model.Difficulty;
import yugioh_recommend.model.SubType;

public class SubResponse {
	
	private UUID id;
	private SubType subType;
	private Difficulty difficulty;
	
	public SubResponse(UUID id, SubType subType, Difficulty difficulty) {
		super();
		this.id = id;
		this.subType = subType;
		this.difficulty = difficulty;
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
