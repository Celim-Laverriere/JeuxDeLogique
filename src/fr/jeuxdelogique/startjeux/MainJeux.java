package fr.jeuxdelogique.startjeux;



import java.util.Scanner;

import fr.jeuxdelogique.Modejeux.Mode;
import fr.jeuxdelogique.menujeux.MenuJeux;
import fr.jeuxdelogique.menujeux.MenuMode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author CELIM
 *
 */

public class MainJeux {

	static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
	
	
	modeDev(args);
	
	int reponse = 0;
	
	MenuJeux jeux = new MenuJeux();
	MenuMode mode = new MenuMode();
				
		do {
				
			jeux.getMenu();
			mode.getMenu();
		
			do {
			
					if (jeux.getChoixJeux().equals("RecherchePlusMoins")) {
						RecherchePlusMoins.mode(mode.getChoixMode());
					}
					
					if (jeux.getChoixJeux().equals("Mastermind")) {
						Mastermind.mode(mode.getChoixMode());
					}
				
					reponse = menu();
					
			} while(reponse == 1);
					
		} while (reponse != 3);
		
		
	}

		public static int menu () {
			
			Scanner sc = new Scanner(System.in);
			int reponseMenu = 0;
			int reponse = 0;
			
				do {
					
					System.out.println("\n\t\t**************************");
					System.out.println("\t\t*          MENU          *");
					System.out.println("\t\t**************************\n");
					System.out.println(" - POUR REJOUER AU MÊME JEU ENTREZ LE NOMBRE 1 DANS LA CONSOLE !");
					System.out.println(" - POUR LANCER UN NOUVEAU JEU ENTREZ LE NOMBRE 2 DANS LA CONSOLE !");
					System.out.println(" - POUR QUITTER LE JEU ENTREZ LE NOMBRE 3 DANS LA CONSOLE !");
					
					try {
						
						reponseMenu = sc.nextInt();
						sc.nextLine();
						
						switch (reponseMenu) {
						
							case 1:
								reponse = 1;
								break;
							case 2:
								reponse = 2;
								break;
							case 3:
								reponse = 3;
								System.out.println("Merci pour votre visite !");
								break;
							default:
								System.out.println("Votre saisi est incorecte : \n");
								break;
							}
						
					} catch (Exception e) {
						System.out.println("Votre saisi est incorecte : \n");
						sc.nextLine();
					}
					
				} while (reponseMenu != 1 && reponseMenu != 2 && reponseMenu != 3);
			
			return reponse;
			
		}
		
		public static void modeDev (String[] args) {
			
			try {
				
				String dev = args[0];
				Mode.modeDev(dev);
			} catch (ArrayIndexOutOfBoundsException e) {
				Mode.modeDev("pas dev");
			}
			
		}
		
		
}

