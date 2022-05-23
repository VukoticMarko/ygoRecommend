package model;

public class SubTypeA { // Associative
	
	SubType subType;
	String difficulty;
	
	public void setDifficulty(int diff) {
		if(diff > 0 && diff <= 3) {
			this.difficulty = "Easy";
		}else if(diff >= 4 && diff <= 6) {
			this.difficulty = "Medium";
		}else if(diff >= 7 && diff <= 9) {
			this.difficulty = "Hard";
		}else this.difficulty = "Master";
	}

	public SubTypeA(SubType subType, String difficulty) {
		super();
		this.subType = subType;
		this.difficulty = difficulty;
	}
	
	
}
