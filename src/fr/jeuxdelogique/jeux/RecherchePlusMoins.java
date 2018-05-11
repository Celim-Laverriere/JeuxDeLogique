package fr.jeuxdelogique.jeux;


import fr.jeuxdelogique.mode.*;
import fr.jeuxdelogique.invalideException.CodeInvalideException;

public class RecherchePlusMoins extends Jeux {

	public RecherchePlusMoins() {

	}

	public static void mode (String mode) throws CodeInvalideException {


		if (mode.equals("Challenger")) {
			ChallengerRecherchePlusMoins challenger = new ChallengerRecherchePlusMoins();
			challenger.playerGame();
		}

		if (mode.equals("Defenseur")) {
			DefenseurRecherchePlusMoins defenseur = new DefenseurRecherchePlusMoins();
			defenseur.playerGame();
		}

		if (mode.equals("Duel")) {
			DuelRecherchePlusMoins duel = new DuelRecherchePlusMoins();
			duel.playerGame();
		}
	}
}
