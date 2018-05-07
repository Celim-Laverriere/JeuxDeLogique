package fr.jeuxdelogique.menujeux;

import java.util.InputMismatchException;
import java.util.Scanner;
import fr.jeuxdelogique.outils.CodeInvalideException;

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
	public void getMenu() throws CodeInvalideException {

		String reponseChoix = "";

		System.out.println("\n\t\t*******************************");
		System.out.println("\t\t*          MENU JEUX          *");
		System.out.println("\t\t*******************************\n");
		System.out.println("\t - Pour jouer à Recherche +/- tape : 1 \n\t - Pour jouer à Mastermind tape : 2");

		do {	

			try {

				System.out.print("\n\t - Entrez votre choix et taper Entrée pour valider : ");
				reponseChoix = sc.nextLine();

					if (!reponseChoix.equals("1") && !reponseChoix.equals("2")) {
						throw new CodeInvalideException("\nAttention votre saisie est incorecte : ! \n- Pour jouer à Recherche +/- tape : 1 \n- Pour jouer à Mastermind tape : 2");
					}
					
			} catch (CodeInvalideException e){
				System.out.println(e.getLocalizedMessage());
				reponseChoix = "modeErre";
			}

			switch (reponseChoix) {

			case "1":
				choixJeux = "RecherchePlusMoins";
				logger.info(choixJeux);
				break;

			case "2":
				choixJeux = "Mastermind";
                logger.info(choixJeux);
				break;
			}

		} while (reponseChoix.equals("modeErre"));


	}

	
	
}

