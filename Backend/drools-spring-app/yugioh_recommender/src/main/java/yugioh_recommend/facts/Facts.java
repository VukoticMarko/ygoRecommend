package yugioh_recommend.facts;

import java.util.List;

import yugioh_recommend.dto.ArchetypeResponse;

public class Facts {
	
	private List<ArchetypeResponse> arList;
	private double helpScore;

	public Facts(){}
	
	
	
	public double getHelpScore() {
		return helpScore;
	}



	public void setHelpScore(double helpScore) {
		this.helpScore = helpScore;
	}



	public List<ArchetypeResponse> getArList() {
		return arList;
	}

	public void setArList(List<ArchetypeResponse> arList) {
		this.arList = arList;
	}
	
	
}
