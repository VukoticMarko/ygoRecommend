package model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Archetype {
	
	// For eg. I'll use Cyber Dragon Archetype
	long id;
	String archetypeName; // "Cyber Dragon"
	String description;
	Type mainTypeOfDeck; // Machine
	List<Type> typesInDeck; // Cyber Dragon has Machine and Dragon type here
	List<SubTypeA> subtypesInDeck; // Effect, Link, Fusion, XYZ
	int deckDifficulty; // 1-12;
	String deckDifficultyString; // Easy (1-3), Medium (4-6), Hard (7-9), Master (10-12) 
	List<ExtraDeckType> extraDeck; // Link, Fusion XYZ
	List<Playstyle> playstyle; // OTK, Beatdown-Aggro
	List<Attribute> attribute; // Light, Dark
	
	public Archetype(long id, String archetypeName, Type mainTypeOfDeck, List<Type> typesInDeck,
			List<SubTypeA> subtypesInDeck, int deckDifficulty, String deckDifficultyString,
			List<ExtraDeckType> extraDeck, List<Playstyle> playstyle, List<Attribute> attribute) {
		super();
		this.id = id;
		this.archetypeName = archetypeName;
		this.mainTypeOfDeck = mainTypeOfDeck;
		this.typesInDeck = typesInDeck;
		this.subtypesInDeck = subtypesInDeck;
		this.deckDifficulty = deckDifficulty;
		this.deckDifficultyString = deckDifficultyString;
		this.extraDeck = extraDeck;
		this.playstyle = playstyle;
		this.attribute = attribute;
	}
	
}
