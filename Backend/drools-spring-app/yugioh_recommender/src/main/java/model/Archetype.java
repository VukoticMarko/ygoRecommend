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
	// Dodaj klase poveznice
	// For eg. I'll use Cyber Dragon Archetype in the comments
	long id;
	String archetypeName; // "Cyber Dragon"
	String description; // Description of decks lore, anime appearance, behavior...
	String howToPlay; // Text description of decks gameplan and strategy
	Type mainTypeOfDeck; // Machine
	List<Type> typesInDeck; // Cyber Dragon has Machine and Dragon type here (By looks of the cards)
	List<SubTypeA> subtypesInDeck; // Effect, Link, Fusion, XYZ
	int deckDifficulty; // 1-12;
	String deckDifficultyString; // Easy (1-3), Medium (4-6), Hard (7-9), Master (10-12) 
	List<ExtraDeckType> extraDeck; // Link, Fusion, XYZ
	List<Playstyle> playstyle; // OTK, Beatdown-Aggro
	List<Attribute> attribute; // Light, Dark
	List<String> keywords; // Keywords that can be used if user wants to do word search.
						   // For Cyber Dragon words are: cyber, dragon, otk, dark, light, machine...
	// Mozda atributi za slike koje ce se koristiti na frontu?
	
}
