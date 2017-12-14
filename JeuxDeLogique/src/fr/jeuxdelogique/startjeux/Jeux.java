package fr.jeuxdelogique.startjeux;

import fr.jeuxdelogique.menujeux.*;

public class Jeux {

	private String choixJeux;
	
	// Constructeur par defaut
	public Jeux() {
		
	}
	
	// Constructeur avec arguments
	public Jeux(String choixJeux) {
		this.setChoixJeux(choixJeux);
		
	}

	
	public String getChoixJeux() {
		return choixJeux;
	}

	public void setChoixJeux(String choixJeux) {
		MenuJeux menuJeux = new MenuJeux();
		choixJeux = menuJeux.getMenu();
		this.choixJeux = choixJeux;
		appleJeux();
	}
	
		// Méthode qui appel le jeux choisi précédement dans le menu.
		public void appleJeux () {
			
			if (choixJeux.equals("RecherchePlusMoins")) {
				RecherchePlusMoins recherche = new RecherchePlusMoins();
				recherche.setChoixMode(null);
			} 
			
			if (choixJeux.equals("Mastermind")) {
				Mastermind mastermind = new Mastermind();
				mastermind.setChoixMode(null);
			}
		}
}
