package yugioh_recommend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import yugioh_recommend.model.Archetype;
import yugioh_recommend.model.Attribute;
import yugioh_recommend.model.Difficulty;
import yugioh_recommend.model.ExtraDeckType;
import yugioh_recommend.model.Playstyle;
import yugioh_recommend.model.Sub;
import yugioh_recommend.model.SubType;
import yugioh_recommend.model.Type;

public class ArchetypeResponse {

	private UUID id;
	private String archetypeName; // "Cyber Dragon"
	private String description; // Description of decks lore, anime appearance, behavior...
	private String howToPlay; // Text description of decks gameplan and strategy
	private Type mainTypeOfDeck; // Machine
	private List<Type> typesInDeck; // Cyber Dragon has Machine and Dragon type here (By looks of the cards)
	private List<SubResponse> subs; // Effect, Link, Fusion, XYZ
	private int deckDifficultyInt; // 1-12;
	private Difficulty deckDifficulty; // Easy (1-3), Medium (4-6), Hard (7-9), Master (10-12) 
	private List<ExtraDeckType> extraDeck; // Link, Fusion, XYZ
	private List<Playstyle> playstyle; // OTK, Beatdown-Aggro
	private List<Attribute> attribute; // Light, Dark
	private List<String> keywords; 
	private double currentScore;
	private int numberOfTypes;
	private List<SubType> helpingSTList;	
	
	public void initHelpingList(List<SubResponse> list) {
		
		List<SubType> finalList = new ArrayList<>();
		for (SubResponse subResponse : list) {
			finalList.add(subResponse.getSubType());
		}
		setHelpingSTList(finalList);
	}
	
	public List<ArchetypeResponse> convertArchToArchResponse(List<Archetype> list){
		
		List<ArchetypeResponse> retList = new ArrayList<ArchetypeResponse>();
		
		for (Archetype arch : list) {
			
			ArchetypeResponse archRes = new ArchetypeResponse(arch);
			int typesInDeck = 0;
			for (Type type : arch.getTypesInDeck()) {
				typesInDeck++;
			}
			archRes.setNumberOfTypes(typesInDeck);
			retList.add(archRes);
		}
		
		return retList;
		
	}
	
	public ArchetypeResponse(Archetype archetype) {
			this.id = archetype.getId();
			this.archetypeName = archetype.getArchetypeName();
			this.description = archetype.getDescription();
			this.howToPlay = archetype.getHowToPlay();
			this.mainTypeOfDeck = archetype.getMainTypeOfDeck();
			this.typesInDeck = archetype.getTypesInDeck();
			this.subs = createSubs(archetype.getSubs());
			this.deckDifficultyInt = archetype.getDeckDifficultyInt();
			this.extraDeck = archetype.getExtraDeck();
			this.playstyle = archetype.getPlaystyle();
			this.attribute = archetype.getAttribute();
			this.keywords = archetype.getKeywords();
			this.setCurrentScore(0);
	}
	
	private List<SubResponse> createSubs(List<Sub> subs2) {
		List<SubResponse> returnList = new ArrayList<SubResponse>();
		for (Sub sub : subs2) {
			returnList
			.add(new SubResponse(sub.getId(), sub.getSubType(), sub.getDifficulty()));
		}
		return returnList;
	}

	public Difficulty convertDifficulty(int diff) {
		if(diff > 0 && diff <= 3) {
			return Difficulty.Easy;
		}else if(diff >= 4 && diff <= 6) {
			return Difficulty.Medium;
		}else if(diff >= 7 && diff <= 9) {
			return Difficulty.Hard;
		}else return Difficulty.Master;
	}
	
	public ArchetypeResponse(UUID id, String archetypeName, String description, String howToPlay, Type mainTypeOfDeck,
			List<Type> typesInDeck, List<Sub> subTypesInDeck, int deckDifficultyInt, Difficulty deckDifficulty,
			List<ExtraDeckType> extraDeck, List<Playstyle> playstyle, List<Attribute> attribute,
			List<String> keywords) {
		super();
		this.id = id;
		this.archetypeName = archetypeName;
		this.description = description;
		this.howToPlay = howToPlay;
		this.mainTypeOfDeck = mainTypeOfDeck;
		this.typesInDeck = typesInDeck;
		//this.subs = subTypesInDeck;
		this.deckDifficultyInt = deckDifficultyInt;
		this.extraDeck = extraDeck;
		this.playstyle = playstyle;
		this.attribute = attribute;
		this.keywords = keywords;
		this.setCurrentScore(0);
	}
	
	public ArchetypeResponse() {
		
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



	public List<SubResponse> getSubs() {
		return subs;
	}



	public void setSubs(List<SubResponse> subTypesInDeck) {
		this.subs = subTypesInDeck;
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

	public double getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(double currentScore) {
		this.currentScore = currentScore;
	}

	public int getNumberOfTypes() {
		return numberOfTypes;
	}

	public void setNumberOfTypes(int numberOfTypes) {
		this.numberOfTypes = numberOfTypes;
	}

	public List<SubType> getHelpingSTList() {
		return helpingSTList;
	}

	public void setHelpingSTList(List<SubType> helpingSTList) {
		this.helpingSTList = helpingSTList;
	}


}
