package fr.jeuxdelogique.menujeux;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuMode implements Menu {

Scanner sc = new Scanner(System.in);
	
	private String choixMode = "";
	private int reponseChoix;
	
	public String getChoixMode() {
		return choixMode;
	}

	public void setChoixMode(String choixMode) {
		this.choixMode = choixMode;
	}
	
	@Override
	public String getMenu() {
		
			do {
				System.out.println("\n\t\t*******************************");
				System.out.println("\t\t*           MENU MODE         *");
				System.out.println("\t\t*******************************\n");
				System.out.println("\t - Pour le mode Challenger tapez : 1 \n\t - Pour le mode Défenseur tapez : 2 \n\t - Pour le mode duel tapez : 3 ");
				
				try {
					
					reponseChoix = sc.nextInt();
					
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
						
						default : 
							System.out.println("Saisi incorecte :");
					}
				
				} catch (InputMismatchException e){
					System.out.println("Saisi incorecte :");
					sc.nextLine();
				}
	
			} while (choixMode != "Challenger" && choixMode != "Defenseur" && choixMode != "Duel");
			
		return choixMode;
	}

}
