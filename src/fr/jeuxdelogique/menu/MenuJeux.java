package fr.jeuxdelogique.menu;

import java.util.Scanner;
import fr.jeuxdelogique.invalideException.CodeInvalideException;

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
        System.out.println("\t - POUR JOUER A RECHERCHE PLUS & MOINS TAPEZ : 1 \n\t - POUR JOUER A MASTERMIND TAPEZ : 2");

        do {

            //Une vérification de la saisie et faite et renvoie en cas d’erreur un message et propose à l'utilisateur de refaire une saisie.
            try {

                System.out.print("\n\t - Entrez votre choix et taper Entrée pour valider : ");
                reponseChoix = sc.nextLine();

                if (!reponseChoix.equals("1") && !reponseChoix.equals("2")) {
                    throw new CodeInvalideException("\n\tAttention votre saisie est incorecte : " + reponseChoix + " !"
                            + " \n\t- Pour jouer à Recherche plus & moins tape : 1 \n\t- Pour jouer à Mastermind tape : 2");
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

