package fr.jeuxdelogique.startjeux;

import java.util.Scanner;

import fr.jeuxdelogique.Modejeux.*;
import fr.jeuxdelogique.menujeux.*;

public class RecherchePlusMoins extends Jeux{

	Scanner sc = new Scanner (System.in);
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
		
		char nouvellePartie = 'O';
		
		if (choixMode.equals("Challenger")) {
			do {
				ChallengerRecherchePlusMoins challenger = new ChallengerRecherchePlusMoins();
				
				System.out.println("Voulez-vous faire une novelle partie O/N");
				nouvellePartie = sc.nextLine().charAt(0);
				nouvellePartie = Character.toUpperCase(nouvellePartie);
				
			} while (nouvellePartie == 'O');
			
		}
		
		if (choixMode.equals("Defenseur")) {
			DefenseurRecherchePlusMoins defenseur = new DefenseurRecherchePlusMoins(null, null, choixMode);
		}
		
		if (choixMode.equals("Duel")) {
			DuelRecherchePlusMoins duel = new DuelRecherchePlusMoins(null, null, choixMode);
		}
	}
}
