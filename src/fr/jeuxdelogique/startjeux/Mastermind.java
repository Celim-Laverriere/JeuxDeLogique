package fr.jeuxdelogique.startjeux;

import fr.jeuxdelogique.Modejeux.*;
import fr.jeuxdelogique.outils.CodeInvalideException;


public class Mastermind extends Jeux{

	
	public Mastermind () {
		
	}

	public Mastermind(String choixMode) {
		
	}

	
	public static void mode (String mode) throws CodeInvalideException {
		
		if (mode.equals("Challenger")) {
			ChallengerMastermind challenger = new ChallengerMastermind();
			challenger.playerGame();
		}
		
		if (mode.equals("Defenseur")) {
			DefenseurMastermind defenseur = new DefenseurMastermind();
			defenseur.playerGame();
		}
		
		if (mode.equals("Duel")) {
			DuelMastermind duel = new DuelMastermind();
			duel.playerGame();
		}
	}
}
