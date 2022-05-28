package dto;

import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import model.Archetype;
import model.Attribute;
import model.Difficulty;
import model.ExtraDeckType;
import model.Playstyle;
import model.SubTypeA;

public class ArchetypeResponse {

	private UUID id;
	private String archetypeName; // "Cyber Dragon"
	private String description; // Description of decks lore, anime appearance, behavior...
	private String howToPlay; // Text description of decks gameplan and strategy
	private Type mainTypeOfDeck; // Machine
	private List<Type> typesInDeck; // Cyber Dragon has Machine and Dragon type here (By looks of the cards)
	private List<SubTypeA> subTypesInDeck; // Effect, Link, Fusion, XYZ
	private int deckDifficultyInt; // 1-12;
	private Difficulty deckDifficulty; // Easy (1-3), Medium (4-6), Hard (7-9), Master (10-12) 
	private List<ExtraDeckType> extraDeck; // Link, Fusion, XYZ
	private List<Playstyle> playstyle; // OTK, Beatdown-Aggro
	private List<Attribute> attribute; // Light, Dark
	private List<String> keywords; 
	
	public ArchetypeResponse(Archetype archetype) {
			this.id = archetype.getId();
			this.archetypeName = archetype.getArchetypeName();
			this.description = archetype.getDescription();
			this.howToPlay = archetype.getHowToPlay();
			this.mainTypeOfDeck = archetype.getMainTypeOfDeck();
			this.typesInDeck = archetype.getTypesInDeck();
			this.subTypesInDeck = archetype.getSubTypesInDeck();
			this.deckDifficultyInt = archetype.getDeckDifficultyInt();
			this.deckDifficulty = archetype.getDeckDifficulty();
			this.extraDeck = archetype.getExtraDeck();
			this.playstyle = archetype.getPlaystyle();
			this.attribute = archetype.getAttribute();
			this.keywords = archetype.getKeywords();
	}
	
	public ArchetypeResponse(UUID id, String archetypeName, String description, String howToPlay, Type mainTypeOfDeck,
			List<Type> typesInDeck, List<SubTypeA> subTypesInDeck, int deckDifficultyInt, Difficulty deckDifficulty,
			List<ExtraDeckType> extraDeck, List<Playstyle> playstyle, List<Attribute> attribute,
			List<String> keywords) {
		super();
		this.id = id;
		this.archetypeName = archetypeName;
		this.description = description;
		this.howToPlay = howToPlay;
		this.mainTypeOfDeck = mainTypeOfDeck;
		this.typesInDeck = typesInDeck;
		this.subTypesInDeck = subTypesInDeck;
		this.deckDifficultyInt = deckDifficultyInt;
		this.deckDifficulty = deckDifficulty;
		this.extraDeck = extraDeck;
		this.playstyle = playstyle;
		this.attribute = attribute;
		this.keywords = keywords;
	}

	

	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getArchetypeName() {
		return archetypeName;
	}
	


	public void setArchetypeName(String archetypeName) {
		this.archetypeName = archetypeName;
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



	public List<Type> getTypesInDeck() {
		return typesInDeck;
	}



	public void setTypesInDeck(List<Type> typesInDeck) {
		this.typesInDeck = typesInDeck;
	}



	public List<SubTypeA> getSubTypesInDeck() {
		return subTypesInDeck;
	}



	public void setSubTypesInDeck(List<SubTypeA> subTypesInDeck) {
		this.subTypesInDeck = subTypesInDeck;
	}



	public int getDeckDifficultyInt() {
		return deckDifficultyInt;
	}



	public void setDeckDifficultyInt(int deckDifficultyInt) {
		this.deckDifficultyInt = deckDifficultyInt;
	}



	public Difficulty getDeckDifficulty() {
		return deckDifficulty;
	}



	public void setDeckDifficulty(Difficulty deckDifficulty) {
		this.deckDifficulty = deckDifficulty;
	}



	public List<ExtraDeckType> getExtraDeck() {
		return extraDeck;
	}



	public void setExtraDeck(List<ExtraDeckType> extraDeck) {
		this.extraDeck = extraDeck;
	}



	public List<Playstyle> getPlaystyle() {
		return playstyle;
	}



	public void setPlaystyle(List<Playstyle> playstyle) {
		this.playstyle = playstyle;
	}



	public List<Attribute> getAttribute() {
		return attribute;
	}



	public void setAttribute(List<Attribute> attribute) {
		this.attribute = attribute;
	}



	public List<String> getKeywords() {
		return keywords;
	}



	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}


}
