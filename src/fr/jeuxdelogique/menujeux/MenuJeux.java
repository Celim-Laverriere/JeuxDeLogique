package fr.jeuxdelogique.menujeux;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuJeux implements Menu{

	Scanner sc = new Scanner(System.in);
	
	private String choixJeux = "";
	
	public String getChoixJeux() {
		return choixJeux;
	}

	public void setChoixJeux(String choixJeux) {
		this.choixJeux = choixJeux;
	}
	
	@Override
	public void getMenu() {
		
		int reponseChoix;
		
			do {
				
				System.out.println("\n\t\t*******************************");
				System.out.println("\t\t*          MENU JEUX          *");
				System.out.println("\t\t*******************************\n");
				System.out.println("\t - Pour jouer à Recherche +/- tape : 1 \n\t - Pour jouer à Mastermind tape : 2");
			
					try { 
					
						reponseChoix = sc.nextInt();
						
						switch (reponseChoix) {
						
							case 1:
								choixJeux = "RecherchePlusMoins";
								break;
								
							case 2:
								choixJeux = "Mastermind";
								break;
								
							default :
								System.out.println("Votre saisi est incorecte : ");
						}
					
					} catch (InputMismatchException e){
						System.out.println("Votre saisi est incorecte : ");
						sc.nextLine();
					}
				
			} while (choixJeux != "RecherchePlusMoins" && choixJeux != "Mastermind");
		
		
	}

	
}

