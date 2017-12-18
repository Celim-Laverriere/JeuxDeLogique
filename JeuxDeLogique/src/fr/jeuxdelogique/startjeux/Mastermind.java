package fr.jeuxdelogique.startjeux;

import fr.jeuxdelogique.Modejeux.*;
import fr.jeuxdelogique.menujeux.*;

public class Mastermind extends Jeux{

	private String choixMode;
	
	public Mastermind () {
		
	}

	public Mastermind(String choixMode) {
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
			ChallengerMastermind challenger = new ChallengerMastermind(null, null, choixMode);
		}
		
		if (choixMode.equals("Defenseur")) {
			DefenseurMastermind defenseur = new DefenseurMastermind(null, null, choixMode);
		}
		
		if (choixMode.equals("Duel")) {
			DuelMastermind duel = new DuelMastermind(null, null, choixMode);
		}
	}
}
