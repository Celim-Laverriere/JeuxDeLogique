package fr.jeuxdelogique.startjeux;

import java.util.Scanner;

public class MainJeux {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char reponse;
		
		// Boucle d'entrée et de sortie de mon programme
		do {
			
			// J'instancie mon objet jeux qui sera mon objet principal qui contiendra tous les objets avenir.
			Jeux jeux = new Jeux();
			jeux.setChoixJeux(null);
			
			System.out.println("Pour rejouer O/N");
			reponse = sc.nextLine().charAt(0);
			
		} while (reponse != 'o');

		
		sc.close();

	}

}
