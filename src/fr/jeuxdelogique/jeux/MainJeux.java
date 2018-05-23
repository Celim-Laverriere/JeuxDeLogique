package fr.jeuxdelogique.jeux;

import java.util.Scanner;

import fr.jeuxdelogique.menu.MenuStartEnd;
import fr.jeuxdelogique.mode.Mode;
import fr.jeuxdelogique.menu.MenuJeux;
import fr.jeuxdelogique.menu.MenuMode;
import fr.jeuxdelogique.invalideException.CodeInvalideException;
import fr.jeuxdelogique.outils.Config;
import fr.jeuxdelogique.outils.Outils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author CELIM
 */

public class MainJeux {

    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) throws CodeInvalideException {

        Config configuration = new Config();
        /*Au lancement de l’application on va traiter l’argument ou non passer en paramètre, pour le mode développeur.*/
        try {

            if (args[0].equals("-dev") ) {
                Mode.modeDev(args[0]);
                logger.info("Mode développeur activé via le lancement de l'application !");
            }

            if (!args[0].equals("-dev")){
                throw  new CodeInvalideException("Le Paramètre " + args[0] + " pour le mode développeur passé au lancement de l'application est invalid !");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            Mode.modeDev("-jou");

        } catch (CodeInvalideException e) {
            System.out.println(e.getLocalizedMessage());
            Mode.modeDev("-jou");
            logger.error("Le Paramètre " + args[0] + " pour le mode développeur passé au lancement de l'application est invalid ! ");
            logger.info("Mode joueur activé par défaut !");

        }

        /* Lancement du mode développeur depuis le fichier de configuration */

        if (args.length < 1) {

            try {

                if (configuration.modeDevelloppeur().equals("-dev")){
                    Mode.modeDev(configuration.modeDevelloppeur());
                    logger.info("Mode développeur activé via le fichier de configuration !");
                }

                if (configuration.modeDevelloppeur().equals("-jou")) {
                    Mode.modeDev("-jou");
                    logger.info("Mode joueur activé !");
                }

                if (!configuration.modeDevelloppeur().equals("-dev") && !configuration.modeDevelloppeur().equals("-jou")){
                    throw  new CodeInvalideException("\n Le Paramètre " + configuration.modeDevelloppeur() + " pour le mode développeur passé dans le fichier de configuration est invalid ! \n");
                }

            } catch (CodeInvalideException e) {
                System.out.println(e.getLocalizedMessage());
                Mode.modeDev("-jou");
                logger.error("\n Le Paramètre " + configuration.modeDevelloppeur() + " pour le mode développeur passé dans le fichier de configuration est invalid ! \n");
                logger.info("Mode joueur activé par défaut !");
            }
        }

        MenuJeux jeux = new MenuJeux();
        MenuMode mode = new MenuMode();
        MenuStartEnd startEnd = new MenuStartEnd();

        do {

            jeux.getMenu();
            mode.getMenu();

            do {

                if (jeux.getChoixJeux().equals("RecherchePlusMoins")) {
                    logger.info(mode.getChoixMode());
                    RecherchePlusMoins.mode(mode.getChoixMode());
                }

                //Puis le programme se déroule et appel la classe « MenuJeu » dans la package « menu ».
                if (jeux.getChoixJeux().equals("Mastermind")) {
                    logger.info(mode.getChoixMode());
                    //Une fois le jeu choisi on retourne à la classe « mainJeux » et va appeler la classe « MenuMode » toujours dans le package « menu »,
                    Mastermind.mode(mode.getChoixMode());
                }

                startEnd.getMenu();

            } while (startEnd.getChoixStartEnd().equals("1"));

        } while (!startEnd.getChoixStartEnd().equals("3"));
    }
}

