package fr.jeuxdelogique.menujeux;

import java.util.Scanner;

public class MenuMode implements Menu {

Scanner sc = new Scanner(System.in);
	
	private String choixMode = "";
	private int reponseChoix;
	
	@Override
	public String getMenu() {
		
		System.out.println("Choissisez le mode du jeu : Pour le mode Challenger tapez : 1 ; Pour le mode Défenseur tapez 2 ; pour le mode duel tapez : 3 ");
		
			try {
				
				reponseChoix = sc.nextInt();
				sc.nextLine();
				
				switch (reponseChoix) {
				
					case 1:
						choixMode = "Challenger";
						break;
					
					case 2:
						choixMode = "Defenseur";
						break;
						
					case 3:
						choixMode = "Duel";
						break; 
						
				}
			
			} catch (ClassCastException e){
				
			}

		return choixMode;
	}

}
