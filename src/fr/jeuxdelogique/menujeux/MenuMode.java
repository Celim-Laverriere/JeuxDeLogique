package fr.jeuxdelogique.menujeux;

import java.util.Scanner;
import fr.jeuxdelogique.outils.CodeInvalideException;

public class MenuMode implements Menu {

Scanner sc = new Scanner(System.in);
	
	private String choixMode = "";
	
	
	public String getChoixMode() {
		return choixMode;
	}

	public void setChoixMode(String choixMode) {
		this.choixMode = choixMode;
	}
	
	@Override
	public void getMenu() throws CodeInvalideException{

		String reponseChoix = "";

		System.out.println("\n\t\t*******************************");
		System.out.println("\t\t*           MENU MODE         *");
		System.out.println("\t\t*******************************\n");
		System.out.println("\t - Pour le mode Challenger tapez : 1 \n\t - Pour le mode Défenseur tapez : 2 \n\t - Pour le mode duel tapez : 3 ");


		do {


			try { 

				reponseChoix = sc.nextLine();

				if (!reponseChoix.equals("1") && !reponseChoix.equals("2") && !reponseChoix.equals("3")) {
					throw new CodeInvalideException("\nAttention votre saisie est incorecte : ! \n\t - Pour le mode Challenger tapez : 1 "
							+ "\n\t - Pour le mode Défenseur tapez : 2 \n\t - Pour le mode duel tapez : 3");
				}

			} catch (CodeInvalideException e){
				System.out.println(e.getLocalizedMessage());
				reponseChoix = "modeErre";
			}
			switch (reponseChoix) {

			case "1":
				choixMode = "Challenger";
				break;

			case "2":
				choixMode = "Defenseur";
				break;

			case "3":
				choixMode = "Duel";
				break; 

			}

		} while (reponseChoix.equals("modeErre"));

	}

}
