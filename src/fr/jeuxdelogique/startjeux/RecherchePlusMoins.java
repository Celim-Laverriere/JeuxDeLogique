package fr.jeuxdelogique.startjeux;


import fr.jeuxdelogique.Modejeux.*;

public class RecherchePlusMoins extends Jeux {

	
	public RecherchePlusMoins() {
		 
	}
	
	public RecherchePlusMoins(String choixMode) {
		
	}

	public static void mode (String mode) {
		
		
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
