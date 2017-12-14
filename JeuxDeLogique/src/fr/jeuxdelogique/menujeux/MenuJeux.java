package fr.jeuxdelogique.menujeux;

import java.util.Scanner;

public class MenuJeux implements Menu{

	Scanner sc =new Scanner(System.in);
	
	private String choixJeux = "";
	private int reponseChoix;
	
	
	@Override
	public String getMenu() {
		
		System.out.println("Pour jouer à Recherche +/- tape : 1 \nPour jouer à Mastermind tape : 2");
		
			try { 
			
				reponseChoix = sc.nextInt();
				sc.nextLine();
				
				switch (reponseChoix) {
				
					case 1:
						choixJeux = "RecherchePlusMoins";
						break;
						
					case 2:
						choixJeux = "Mastermind";
						break;
				}
			
			} catch (ClassCastException e){
				
			}
	
		return choixJeux;
	}
	
}

