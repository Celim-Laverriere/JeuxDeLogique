package fr.jeuxdelogique.jeux;

import java.util.Scanner;

import fr.jeuxdelogique.mode.Mode;
import fr.jeuxdelogique.menu.MenuJeux;
import fr.jeuxdelogique.menu.MenuMode;
import fr.jeuxdelogique.invalideException.CodeInvalideException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author CELIM
 */

public class MainJeux {

    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CodeInvalideException {

        try {

            if (args[0].equals("-dev")) {
                Mode.modeDev(args[0]);
                logger.info("Mode developpeur activé !");
            } else if (!args[0].equals("developpeur")){
                System.out.println("Paramètre inconnu !");
            } else {
                Mode.modeDev("ModeJoueur");
                logger.info("Mode joueur active !");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            Mode.modeDev("ModeJoueur");
            logger.info("Mode joueur activé !");
        }

        String reponse = "";

        MenuJeux jeux = new MenuJeux();
        MenuMode mode = new MenuMode();

        do {

            jeux.getMenu();
            mode.getMenu();

            do {

                if (jeux.getChoixJeux().equals("RecherchePlusMoins")) {
                    logger.info(mode.getChoixMode());
                    RecherchePlusMoins.mode(mode.getChoixMode());
                }

                if (jeux.getChoixJeux().equals("Mastermind")) {
                    logger.info(mode.getChoixMode());
                    Mastermind.mode(mode.getChoixMode());
                }

                reponse = menu();

            } while (reponse == "1");

        } while (reponse != "3");

    }

    public static String menu() {

        Scanner sc = new Scanner(System.in);
        String reponseMenu = "";
        String reponse = "";

        System.out.println("\n\t\t**************************");
        System.out.println("\t\t*          MENU          *");
        System.out.println("\t\t**************************\n");
        System.out.println(" - POUR REJOUER AU MÊME JEU ENTREZ LE NOMBRE 1 DANS LA CONSOLE !");
        System.out.println(" - POUR LANCER UN NOUVEAU JEU ENTREZ LE NOMBRE 2 DANS LA CONSOLE !");
        System.out.println(" - POUR QUITTER LE JEU ENTREZ LE NOMBRE 3 DANS LA CONSOLE !\n");

        do {

            try {

                System.out.print(" Entrez votre choix et tapez entrée pour valider : ");
                reponseMenu = sc.nextLine();

                if (!reponseMenu.equals("1") && !reponseMenu.equals("2") && !reponseMenu.equals("3")) {
                    throw new CodeInvalideException("\n Attention votre saisie est incorrecte : " + reponseMenu + " !");
                }

            } catch (CodeInvalideException e) {
                System.out.println(e.getLocalizedMessage());
                reponseMenu = "modeErre";
            }

            switch (reponseMenu) {

                case "1":
                    reponse = "1";
                    break;
                case "2":
                    reponse = "2";
                    break;
                case "3":
                    reponse = "3";
                    System.out.println("\n **** Merci pour votre visite ! **** \n");
                    break;
            }

        } while (reponseMenu.equals("modeErre"));

        return reponse;
    }
}

