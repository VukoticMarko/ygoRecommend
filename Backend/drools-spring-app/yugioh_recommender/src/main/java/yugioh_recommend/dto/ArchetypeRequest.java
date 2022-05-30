package yugioh_recommend.dto;

import java.util.List;

import yugioh_recommend.model.Attribute;
import yugioh_recommend.model.Difficulty;
import yugioh_recommend.model.ExtraDeckType;
import yugioh_recommend.model.SubType;
import yugioh_recommend.model.Type;

public class ArchetypeRequest {
	
	private String name;
	private String description;
	private String howToPlay;
	private Type mainTypeOfDeck;
	private List<Type> chosenTypes;
	private List<SubType> chosenSubTypes;
	private int chosenDifficulty;
	private Difficulty difficulty;
	private List<ExtraDeckType> chosenExtraDeckMechanics;
	private String chosenPlaystyle;
	private Attribute attribute;
	private String keywords;
	private float currentScore;
	
	public ArchetypeRequest() {
		
	}
	
	// Constructor for recommend system
	public ArchetypeRequest(List<Type> chosenTypes, List<SubType> chosenSubTypes, int chosenDifficulty,
			List<ExtraDeckType> chosenExtraDeckMechanics, String chosenPlaystyle) {
		super();
		this.chosenTypes = chosenTypes;
		this.chosenSubTypes = chosenSubTypes;
		this.chosenDifficulty = chosenDifficulty;
		this.chosenPlaystyle = chosenPlaystyle;
		this.chosenExtraDeckMechanics = chosenExtraDeckMechanics;
	}
	
	// Constructor for CRUD operations
	public ArchetypeRequest(String name, String description, String howToPlay, Type mainTypeOfDeck,
			List<Type> chosenTypes, List<SubType> chosenSubTypes, int chosenDifficulty, Difficulty difficulty,
			List<ExtraDeckType> chosenExtraDeckMechanics, String chosenPlaystyle, Attribute attribute, String keywords) {
		super();
		this.name = name;
		this.description = description;
		this.howToPlay = howToPlay;
		this.mainTypeOfDeck = mainTypeOfDeck;
		this.chosenTypes = chosenTypes;
		this.chosenSubTypes = chosenSubTypes;
		this.chosenDifficulty = chosenDifficulty;
		this.difficulty = difficulty;
		this.chosenExtraDeckMechanics = chosenExtraDeckMechanics;
		this.chosenPlaystyle = chosenPlaystyle;
		this.attribute = attribute;
		this.keywords = keywords;
	}

	
	public float getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(float currentScore) {
		this.currentScore = currentScore;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHowToPlay() {
		return howToPlay;
	}

	public void setHowToPlay(String howToPlay) {
		this.howToPlay = howToPlay;
	}

	public Type getMainTypeOfDeck() {
		return mainTypeOfDeck;
	}

	public void setMainTypeOfDeck(Type mainTypeOfDeck) {
		this.mainTypeOfDeck = mainTypeOfDeck;
	}

	public List<Type> getChosenTypes() {
		return chosenTypes;
	}

	public void setChosenTypes(List<Type> chosenTypes) {
		this.chosenTypes = chosenTypes;
	}

	public List<SubType> getChosenSubTypes() {
		return chosenSubTypes;
	}

	public void setChosenSubTypes(List<SubType> chosenSubTypes) {
		this.chosenSubTypes = chosenSubTypes;
	}

	public int getChosenDifficulty() {
		return chosenDifficulty;
	}

	public void setChosenDifficulty(int chosenDifficulty) {
		this.chosenDifficulty = chosenDifficulty;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public List<ExtraDeckType> getChosenExtraDeckMechanics() {
		return chosenExtraDeckMechanics;
	}

	public void setChosenExtraDeckMechanics(List<ExtraDeckType> chosenExtraDeckMechanics) {
		this.chosenExtraDeckMechanics = chosenExtraDeckMechanics;
	}

	public String getChosenPlaystyle() {
		return chosenPlaystyle;
	}

	public void setChosenPlaystyle(String chosenPlaystyle) {
		this.chosenPlaystyle = chosenPlaystyle;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	
	
} 
