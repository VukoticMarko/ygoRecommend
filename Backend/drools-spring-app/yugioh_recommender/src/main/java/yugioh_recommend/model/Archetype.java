package yugioh_recommend.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity(name = "archetypes")
public class Archetype {
	// Dodaj klase poveznice
	// For eg. I'll use Cyber Dragon Archetype in the comments
	@Id
    @Column(name = "id", columnDefinition = "varchar(36)")
    @org.hibernate.annotations.Type(type = "uuid-char")
	private UUID id;
	
	@Column(name = "archetype_name")
	private String archetypeName; // "Cyber Dragon"
	
	@Column(name = "description")
	private String description; // Description of decks lore, anime appearance, behavior...
	
	@Column(name = "how_to_play")
	private String howToPlay; // Text description of decks gameplan and strategy
	
	
	@Column(name = "main_type_of_deck")
	@Enumerated(EnumType.STRING)
	private Type mainTypeOfDeck; // Machine
	
	
	@ElementCollection(targetClass=Type.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "archetype_types_in_deck")
    @Column(name = "types_in_deck")
	private List<Type> typesInDeck; // Cyber Dragon has Machine and Dragon type here (By looks of the cards)

	
	@ManyToMany
	@JoinTable(
	  name = "archetype_sub_types_in_deck", 
	  joinColumns = @JoinColumn(name = "archetype_id"), 
	  inverseJoinColumns = @JoinColumn(name = "sub_id"))
	@Fetch(FetchMode.JOIN)
	private List<Sub> subs; // Effect, Link, Fusion, XYZ
	
	
	@Column(name = "deck_difficulty_int")
	private int deckDifficultyInt; // 1-12;
	
	
//	@Column(name = "deck_difficulty")
//	@Enumerated(EnumType.STRING)
//	private Difficulty deckDifficulty;
	
	
	@ElementCollection(targetClass=ExtraDeckType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "archetype_extra_deck")
    @Column(name = "extra_deck")
	private List<ExtraDeckType> extraDeck; // Link, Fusion, XYZ
	
	
	@ElementCollection(targetClass=Playstyle.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "archetype_playstyle")
    @Column(name = "playstyle")
	private List<Playstyle> playstyle; // OTK, Beatdown-Aggro
	
	
	@ElementCollection(targetClass=Attribute.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "archetype_attribute")
    @Column(name = "attribute")
	private List<Attribute> attribute; // Light, Dark
	
	
	@ElementCollection(targetClass=String.class)
    @CollectionTable(name = "archetype_keywords")
    @Column(name = "keywords")
	private List<String> keywords; // Keywords that can be used if user wants to do word search.
						   // For Cyber Dragon words are: cyber, dragon, otk, dark, light, machine...
	// Mozda atributi za slike koje ce se koristiti na frontu?
	//private String base64Image
	
	// Score for rating the archetype in recommendation
	@Transient
	private double current_score;
	
	public Archetype() {
		this.current_score = 0;
	}

	public Archetype(UUID id, String archetypeName, String description, String howToPlay,
								Type mainTypeOfDeck, List<Type> typesInDeck, List<Sub> subTypesInDeck,
								int deckDifficultyInt, List<ExtraDeckType> extraDeck,
								List<Playstyle> playstyle, List<Attribute> attribute, List<String> keywords) {
							super();
							this.id = id;
							this.archetypeName = archetypeName;
							this.description = description;
							this.howToPlay = howToPlay;
							this.mainTypeOfDeck = mainTypeOfDeck;
							this.typesInDeck = typesInDeck;
							this.subs = subTypesInDeck;
							this.deckDifficultyInt = deckDifficultyInt;
							this.extraDeck = extraDeck;
							this.playstyle = playstyle;
							this.attribute = attribute;
							this.keywords = keywords;
							this.current_score = 0;
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


	public List<Sub> getSubs() {
		return subs;
	}


	public void setSubs(List<Sub> subTypesInDeck) {
		this.subs = subTypesInDeck;
	}


	public int getDeckDifficultyInt() {
		return deckDifficultyInt;
	}


	public void setDeckDifficultyInt(int deckDifficultyInt) {
		this.deckDifficultyInt = deckDifficultyInt;
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
