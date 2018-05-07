package fr.jeuxdelogique.startjeux;


import fr.jeuxdelogique.Modejeux.*;
import fr.jeuxdelogique.outils.CodeInvalideException;

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
