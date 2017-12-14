package fr.jeuxdelogique.startjeux;

import fr.jeuxdelogique.Modejeux.ChallengerRecherchePlusMoins;
import fr.jeuxdelogique.menujeux.*;

public class RecherchePlusMoins extends Jeux{

	private String choixMode;
	
	public RecherchePlusMoins() {
		 
	}
	
	public RecherchePlusMoins(String choixMode) {
		this.setChoixMode(choixMode);
	}


	public String getChoixMode() {
		return choixMode;
	}

	public void setChoixMode(String choixMode) {
		MenuMode menuMode = new MenuMode();
		choixMode = menuMode.getMenu();
		this.choixMode = choixMode;
		mode();
	}
	
	public void mode () {
		
		if (choixMode.equals("Challenger")) {
			ChallengerRecherchePlusMoins challenger = new ChallengerRecherchePlusMoins(null, null, null);
		}
		
		if (choixMode.equals("Defenseur")) {
			Defenseur defenseur = new Defenseur();
		}
		
		if (choixMode.equals("Duel")) {
			Duel duel = new Duel();
		}
	}
}
