package fr.jeuxdelogique.startjeux;

import fr.jeuxdelogique.Modejeux.*;
import fr.jeuxdelogique.menujeux.*;

public class Mastermind extends Jeux{

	
	public Mastermind () {
		
	}

	public Mastermind(String choixMode) {
		
	}

	
	public static void mode (String mode) {
		
		if (mode.equals("Challenger")) {
			ChallengerMastermind challenger = new ChallengerMastermind();
			challenger.playerGame();
		}
		
		if (mode.equals("Defenseur")) {
			DefenseurMastermind defenseur = new DefenseurMastermind();
		}
		
		if (mode.equals("Duel")) {
			DuelMastermind duel = new DuelMastermind();
		}
	}
}
