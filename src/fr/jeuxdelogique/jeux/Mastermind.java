package fr.jeuxdelogique.jeux;

import fr.jeuxdelogique.mode.*;
import fr.jeuxdelogique.invalideException.CodeInvalideException;


public class Mastermind extends Jeux{

	public Mastermind () {

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
